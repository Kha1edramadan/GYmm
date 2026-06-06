package com.example.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.*
import java.util.concurrent.TimeUnit

// ── Sitting Reminder Worker ────────────────────────────────────────────────────
// Runs every 30 minutes via WorkManager and fires a system notification.
// Uses IMPORTANCE_HIGH so it shows as heads-up popup.
// The notification channel uses STREAM_ALARM audio to bypass DND.

class SittingReminderWorker(
    private val ctx: Context,
    params: WorkerParameters
) : Worker(ctx, params) {

    companion object {
        const val CHANNEL_ID  = "igym_sitting_reminder"
        const val WORK_TAG    = "sitting_reminder"
        const val NOTIF_ID    = 7001

        // Simple movement reminders
        private val MOVEMENT_MESSAGES = listOf(
            "قوم خد جولة صغيرة، 5 دقايق بس 🚶",
            "نص ساعة على الكرسي! وقتك تتحرك شوية 💡",
            "جسمك محتاج حركة، قوم اتمشى 🌿",
            "5 دقايق واقف أحسن من ساعة تعب لاحقاً ⚡",
            "الجلوس الطويل بيأثر على أداءك، قوم اتحرك 🎯",
            "استراحة حركة! قوم خد نفسك شوية 🔋",
            "جسمك اشتكى منك، قوم بقى 😄🚶",
            "حرّك ظهرك ورقبتك، دلوقتي 🔄",
            "امشِ دقيقة بس — جسمك هيشكرك 🏃",
            "فك جسمك شوية، وقفة بسيطة بتحدث فرق كبير 💪"
        )

        // Motivational health quotes with attribution
        private val HEALTH_QUOTES = listOf(
            Pair("\"الجسم السليم في العقل السليم — واللي بيتحرك بيفكر أحسن\"", "يونال الرياضي"),
            Pair("\"الحركة دواء — والجلوس الطويل مرض بطيء\"", "ד\"ר جيمس ليفين، مايو كلينيك"),
            Pair("\"ما من دواء يُعوّض قوة التمرين اليومي\"", "تشارلز ييجر، مدرب الأداء"),
            Pair("\"الجلوس ٦ ساعات يوميًا يرفع خطر القلب ٦٠٪\"", "مجلة Heart البريطانية"),
            Pair("\"الانضباط اليوم راحة لا تُقدّر غدًا\"", "جيمس كلير، كتاب Atomic Habits"),
            Pair("\"البناء العضلي يبدأ خارج الجيم — النوم والحركة اليومية هم الأساس\"", "د. ستيوارت ماكغيل"),
            Pair("\"كل ١٠ دقايق حركة بتقلل الالتهاب وبتحسن التركيز\"", "معهد الصحة الأمريكي NIH"),
            Pair("\"الوقفة البسيطة بتنشط الدورة الدموية وبتخلي تفكيرك أوضح\"", "د. آندرو هوبرمان، ستانفورد"),
            Pair("\"جسمك ما بيعرفش يفرق بين الراحة والكسل — إنت اللي بتفرّق\"", "خالد"),
            Pair("\"التمرين مش بيسرق وقتك، بيزوده — كل ساعة رياضة بتديك أربعة مقابلها\"", "د. مايكل مواريكي")
        )

        private val MESSAGES get() = MOVEMENT_MESSAGES

        fun getRandomQuote(): Pair<String, String> = HEALTH_QUOTES.random()

        fun schedule(context: Context) {
            val request = PeriodicWorkRequestBuilder<SittingReminderWorker>(
                30, TimeUnit.MINUTES,
                5,  TimeUnit.MINUTES   // flex interval
            )
                .addTag(WORK_TAG)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_TAG,
                ExistingPeriodicWorkPolicy.UPDATE,
                request
            )
        }

        fun cancel(context: Context) {
            WorkManager.getInstance(context).cancelAllWorkByTag(WORK_TAG)
        }

        fun isScheduled(context: Context): Boolean {
            val infos = WorkManager.getInstance(context)
                .getWorkInfosByTag(WORK_TAG)
                .get()
            return infos.any { it.state == WorkInfo.State.ENQUEUED || it.state == WorkInfo.State.RUNNING }
        }
    }

    override fun doWork(): Result {
        createChannel()

        // Alternate between movement reminders and motivational quotes
        val useQuote = System.currentTimeMillis() % 3 == 0L
        val (title, body) = if (useQuote) {
            val (quote, source) = getRandomQuote()
            "IGYM 💡" to "$quote\n— $source"
        } else {
            val message = MESSAGES.random()
            "IGYM – وقت الحركة! 🚶" to message
        }

        val notif = NotificationCompat.Builder(ctx, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(0, 400, 150, 400))
            .build()

        val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.notify(NOTIF_ID, notif)
        return Result.success()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (nm.getNotificationChannel(CHANNEL_ID) != null) return

            val channel = NotificationChannel(
                CHANNEL_ID,
                "IGYM – تذكير الحركة",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "تذكير كل 30 دقيقة للوقوف والتحرك"
                enableVibration(true)
                vibrationPattern = longArrayOf(0, 400, 150, 400)
                // Use alarm stream so it plays even in DND
                val audioAttr = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build()
                setSound(
                    RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM),
                    audioAttr
                )
                setBypassDnd(true)
                lockscreenVisibility = android.app.Notification.VISIBILITY_PUBLIC
            }
            nm.createNotificationChannel(channel)
        }
    }
}
