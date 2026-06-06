package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.ui.components.GlassCard
import com.example.ui.theme.*

data class SupplementInfo(
    val name:          String,
    val nameAr:        String,
    val tier:          String,
    val tierColor:     Long,
    val summary:       String,
    val worthIt:       String,
    val dose:          String,
    val timing:        String,
    val whenNeeded:    String,
    val whenNotNeeded: String,
    val fromFood:      String,
    val warnings:      String,
    val buyingGuide:   String = "",
    val cycleGuide:    String = ""
)

private val supplements = listOf(
    SupplementInfo(
        name          = "Creatine Monohydrate",
        nameAr        = "كرياتين",
        tier          = "أساسي",
        tierColor     = 0xFFC3F400,
        summary       = "أكثر مكمل رياضي تم دراسته في التاريخ. يزود الخلايا بطاقة إضافية للتكرارات الأخيرة.",
        worthIt       = "أيوه بقوة. 500+ دراسة علمية تؤكد فعاليته. يرفع القوة والحجم بشكل ملموس خلال 4-6 أسابيع.",
        dose          = "3–5 جرام يومياً، مفيش داعي لـ Loading Phase",
        timing        = "أي وقت خلال اليوم، التوقيت مش مهم",
        whenNeeded    = "لو بتتمرن بانتظام وعايز تحسّن الأداء. من أول يوم في الجيم.",
        whenNotNeeded = "لو مش بتتمرن أو بتلعب رياضة تحمل فقط زي الماراثون.",
        fromFood      = "موجود في اللحمة والسمك لكن بكميات صغيرة جداً، يعني لازم تاكل كيلوز عشان توصل للجرعة.",
        warnings      = "لازم تشرب مياه كفاية. آمن تماماً مع الكلى الطبيعية. لو عندك مشكلة كلوي استشر دكتور.",
        buyingGuide   = "اشتري Creatine Monohydrate بس، مش HCL ولا Ethyl Ester ولا Buffered. كلهم نفس النتيجة بسعر أغلى.\n\nالسوق المصري:\nMyprotein Impact Creatine، الأرخص بجودة مضمونة\nON Micronized Creatine، الأشهر والأكثر انتشاراً\nBulkSupplements (أونلاين)، بودرة نقية بأرخص سعر\n\nابحث على: Creapure® logo على العلبة ده معناه أعلى نقاء.",
        cycleGuide    = "مش محتاج تقطعه خالص. خذه كل يوم حتى أيام الراحة. بعض الناس بيوقفوه 4-6 أسابيع كل سنة بس مفيش دليل علمي إن ده ضروري."
    ),
    SupplementInfo(
        name          = "Whey Protein",
        nameAr        = "بروتين مصل اللبن",
        tier          = "حسب الاحتياج",
        tierColor     = 0xFFC3F400,
        summary       = "مصدر بروتين سريع الامتصاص. مش سحر، هو بس بروتين في شكل مريح.",
        worthIt       = "لو صعب توصل للـ Protein Target اليومي من الأكل العادي. لو بتاكل بروتين كافي، مش محتاجه.",
        dose          = "حسب ما تحتاجه من بروتين، 1 سيرفينج ≈ 25-30 جرام بروتين",
        timing        = "أي وقت. بعد التمرين مش إلزامي زي ما الناس بتقول.",
        whenNeeded    = "لما الأكل مش كافي أو وقتك ضيق. طلاب وناس مشغولة.",
        whenNotNeeded = "لو بتاكل لحمة وبيض وبقوليات كافية في يومك.",
        fromFood      = "بيض ودجاج ولحمة وجبنة، كلها بروتين ممتاز. الـ Whey بس أسرع وأسهل.",
        warnings      = "مش للناس اللي عندها حساسية من اللاكتوز، جرب Plant-Based بديل.",
        buyingGuide   = "Whey Concentrate كافي لمعظم الناس وأرخص. Whey Isolate لو عندك حساسية لاكتوز أو بتحاول تقطع الدهون.\n\nالسوق المصري:\nMyprotein Impact Whey، الأرخص لكل جرام بروتين\nON Gold Standard، الأشهر والأكثر انتشاراً في مصر\nDymatize ISO-100، Isolate عالي الجودة\nRule1 Whey Isolate، نقاء عالي بسعر معقول\n\nاقرأ Nutrition Label: ابحث على 20g+ بروتين لكل سيرفينج و3g سكر أو أقل.",
        cycleGuide    = "مفيش cycle. هو مجرد أكل. لو بتاكل بروتين كافي من مصادر أخرى توقف عنه في أي وقت."
    ),
    SupplementInfo(
        name          = "Omega-3",
        nameAr        = "أوميجا 3، زيت السمك",
        tier          = "أساسي",
        tierColor     = 0xFFC3F400,
        summary       = "يقلل الالتهاب، يسرع التعافي، ومهم لصحة القلب والمفاصل.",
        worthIt       = "أيوه. خصوصاً لو مش بتاكل سمك بانتظام. فرق ملموس في المفاصل والتعافي.",
        dose          = "2–3 جرام EPA+DHA يومياً",
        timing        = "مع وجبة فيها دهون للامتصاص الأحسن",
        whenNeeded    = "لو بتاكل سمك أقل من مرتين في الأسبوع. لو بتتمرن بشدة.",
        whenNotNeeded = "لو بتاكل سمك دهني 3+ مرات أسبوعياً زي السردين والسلمون.",
        fromFood      = "سردين، سلمون، ماكريل، أفضل مصدر طبيعي بكتير.",
        warnings      = "جرعات عالية ممكن تخفف الدم. استشر دكتور لو بتاخد مميعات.",
        buyingGuide   = "الأهم على العلبة: EPA+DHA combined مش إجمالي الأوميجا 3. مثلاً Fish Oil 1000mg قد يكون فيه 300mg EPA+DHA بس — يعني هتاخد 6-7 كبسولات عشان توصل للجرعة!\n\nاختار منتج يدي 500mg+ EPA+DHA في كل كبسولة.\n\nالسوق المصري:\nSolgar Triple Strength Omega-3 (900mg/كبسولة) — الأفضل، كبسولتين تكفي\nNow Foods Ultra Omega-3 (600mg/كبسولة) — جودة ممتازة بسعر معقول\nNordic Naturals Ultimate Omega (650mg/كبسولة) — الأجود والأغلى\nMegaRed Krill Oil Extra Strength — بديل ممتاز بدون رائحة سمك\n\nمستورد: Thorne Super EPA — جودة عالية جداً وموثوق",
        cycleGuide    = "يومياً بلا توقف. خذه مع وجبة فيها دهون للامتصاص الأحسن."
    ),
    SupplementInfo(
        name          = "Vitamin D3 + K2",
        nameAr        = "فيتامين د + ك2",
        tier          = "أساسي",
        tierColor     = 0xFFC3F400,
        summary       = "40% من الناس عندهم نقص من غير ما يعرفوا. بيأثر على الهرمونات والمناعة والعظام.",
        worthIt       = "أيوه جداً. النقص مرتبط بانخفاض التستوستيرون وضعف الأداء الرياضي.",
        dose          = "2000–5000 IU فيتامين D3 + 100 مكجم K2",
        timing        = "مع وجبة دسمة، فيتامين ذائب في الدهون",
        whenNeeded    = "لو مش بتتعرض للشمس كفاية. معظم الناس محتاجينه خصوصاً في الشتاء.",
        whenNotNeeded = "لو حصلت على تحليل دم وثبت مستوياتك طبيعية.",
        fromFood      = "الشمس هي المصدر الأساسي. سمك السلمون والبيض بكميات محدودة.",
        warnings      = "K2 مهم جداً مع D3 عشان يوجّه الكالسيوم للعظام مش الشرايين.",
        buyingGuide   = "D3 مش D2 (الثاني أقل فاعلية). مع K2 MK-7 مش MK-4 (الأبطأ تحلل = فاعلية أطول).\n\nالسوق المصري:\nNow Foods D3+K2 (5000 IU)، الأوفر سعراً والأكثر توفراً\nJarrow Formulas D3+K2، جودة عالية\nHealthy Origins D3 + Jarrow K2 منفصلين لو عايز تتحكم أكتر في الجرعة\n\nعمل تحليل 25-OH Vitamin D قبل ما تبدأ وبعد 3 شهور تعرف وين أنت.",
        cycleGuide    = "يومياً بلا توقف. عمل تحليل دم كل 6 شهور تطمن."
    ),
    SupplementInfo(
        name          = "Magnesium Glycinate",
        nameAr        = "مغنيسيوم",
        tier          = "مفيد جداً",
        tierColor     = 0xFFFFB347,
        summary       = "بيتفقد في العرق أثناء التمرين. مهم للنوم والتقلصات العضلية وأكثر من 300 وظيفة.",
        worthIt       = "أيوه لو بتتمرن بشدة أو بتعاني من نوم سيء أو تقلصات.",
        dose          = "200–400 مجم Glycinate أو Bisglycinate",
        timing        = "قبل النوم بـ 30-60 دقيقة",
        whenNeeded    = "لو بتتعرق كتير في التمرين. لو نومك مش كويس. لو بتحس بتقلصات.",
        whenNotNeeded = "لو بتاكل مكسرات وخضار ورقي وبقوليات بكميات كافية.",
        fromFood      = "اللوز، السبانخ، البقوليات، الشوكولاتة الداكنة، مصادر ممتازة.",
        warnings      = "أشكال Oxide و Sulfate أقل امتصاصاً وممكن تعمل إسهال. Glycinate الأفضل.",
        buyingGuide   = "ابحث على Magnesium Glycinate أو Bisglycinate على العلبة. Citrate تاني خيار جيد (نعم ممكن إسهال خفيف). Oxide تجنبه خالص.\n\nالسوق المصري:\nDoctor's Best High Absorption Magnesium، الأشهر والأكثر دراسة\nNow Foods Magnesium Glycinate، سعر أقل بجودة مضمونة\nSolgar Chelated Magnesium، متاح في بعض الصيدليات\n\nلو لقيت Magtein (Magnesium L-Threonate) ده يوصل للدماغ وممتاز للتركيز والنوم لكن أغلى.",
        cycleGuide    = "يومياً بلا توقف. مكمل أمان عالي."
    ),
    SupplementInfo(
        name          = "Caffeine",
        nameAr        = "كافيين",
        tier          = "مفيد",
        tierColor     = 0xFFFFB347,
        summary       = "محسّن الأداء الأكتر دراسة. يرفع القوة والتركيز ويأخر الإحساس بالتعب.",
        worthIt       = "أيوه كـ Pre-Workout. لكن مفيش داعي تشتري مكمل، قهوة عادية بتعمل نفس الشيء.",
        dose          = "3–6 مجم لكل كيلو من وزنك، كوباية قهوة ≈ 80-100 مجم",
        timing        = "30-60 دقيقة قبل التمرين",
        whenNeeded    = "لو محتاج طاقة ذهنية وجسدية إضافية للتمرين.",
        whenNotNeeded = "لو حساس للكافيين أو عندك قلق أو مشاكل نوم.",
        fromFood      = "قهوة، شاي، شيكولاتة داكنة، مصادر طبيعية ممتازة.",
        warnings      = "خذ فترات راحة أسبوعية عشان متتعمدش مقاومة. لا تستخدم بعد 2-3 ظهر.",
        buyingGuide   = "مش محتاج تشتري مكمل. 2 كوباية قهوة سوداء قبل التمرين بتعمل نفس اللي بيتباع بمئات الجنيهات.\n\nلو عايز مكمل بس:\nCaffeine 200mg tablets (أي ماركة)، أرخص وأبسط\nPre-workout اللي فيه Caffeine + Beta-Alanine + Citrulline زي C4 أو Ghost Pre-workout\n\nتجنب Pre-workouts اللي فيها مكونات كتير مجهولة أو Proprietary Blends.",
        cycleGuide    = "وقّف أسبوع كامل كل 6-8 أسابيع تعيد حساسيتك له. لو بتتمرن بكرة متشربش قهوة بعد 2-3 ظهر."
    ),
    SupplementInfo(
        name          = "Zinc",
        nameAr        = "زنك",
        tier          = "مفيد",
        tierColor     = 0xFFFFB347,
        summary       = "مهم لإنتاج التستوستيرون والمناعة والتئام الجروح. بيتفقد في العرق أثناء التمرين.",
        worthIt       = "أيوه لو بتتمرن بشدة وأكلك مش متنوع. لكن لازم تنتبه لموضوع النحاس مع الاستخدام الطويل.",
        dose          = "15–25 مجم يومياً من Zinc Bisglycinate أو Picolinate",
        timing        = "مع الطعام لتجنب الغثيان — بعيد عن الكالسيوم بساعتين",
        whenNeeded    = "رياضيون وناس بتتمرن بشدة. نباتيون (مصادر نباتية أقل امتصاصاً).",
        whenNotNeeded = "لو بتاكل لحمة وبحريات وكبدة بانتظام — ممكن تكون مش محتاجه.",
        fromFood      = "المحار الأعلى مصدر، بعدين لحمة البقر والكبدة وبذور اليقطين.",
        warnings      = "⚠️ تنبيه مهم: الاستخدام الطويل للزنك بدون نحاس يعمل نقص نحاس في الجسم. الحل: إما تاخد Zinc مع Copper (2mg نحاس لكل 25mg زنك) أو تاخد استراحة شهر كل 3 شهور. لا تتجاوز 40 مجم/يوم.",
        buyingGuide   = "الشكل المهم: Bisglycinate أو Picolinate — الأفضل امتصاصاً. Oxide تجنبه خالص.\n\n⚠️ مش كل Zinc في السوق يجيله Copper — تأكد قبل الشراء.\n\nالسوق المصري:\nNow Foods Zinc Bisglycinate 30mg + Copper — الأفضل لأنه يحتوي نحاس\nSolgar Zinc 50mg Chelated — متاح في الصيدليات الكبيرة، لكن بدون نحاس\nThorne Zinc Picolinate 15mg — جرعة معتدلة آمنة للاستخدام اليومي\nGarden of Life Zinc Complex — يحتوي zinc + مغنيسيوم\n\nمستورد: Thorne Zinc Copper Chelate — الأفضل لأنه يجمع الاثنين في كبسولة واحدة.",
        cycleGuide    = "لو مع Copper: يومياً بلا توقف. لو بدون Copper: شهر تاخده، أسبوع وقفة — أو تعمل تحليل ZnRBC كل 6 شهور."
    ),
    SupplementInfo(
        name          = "Beta-Alanine",
        nameAr        = "بيتا ألانين",
        tier          = "اختياري",
        tierColor     = 0xFF888888,
        summary       = "يأخر حرقة العضلات في التكرارات العالية (8-15). مش للقوة، للتحمل العضلي.",
        worthIt       = "لو تدريبك على High-Reps والـ Hypertrophy. ملوش أهمية كبيرة للـ Strength.",
        dose          = "3.2–6.4 جرام يومياً، يتراكم في الأنسجة",
        timing        = "يومياً مش مرتبط بوقت التمرين",
        whenNeeded    = "متقدمون في التمرين يدوروا على Edge بسيطة في الأداء.",
        whenNotNeeded = "مبتدئون. ناس بتعمل Low-Rep Strength Training بس.",
        fromFood      = "لا يوجد مصدر غذائي عملي، لازم مكمل لو عايز الجرعة الفعالة.",
        warnings      = "التنميل (Paresthesia) طبيعي ومش خطير. خفف الجرعة لو مزعجتك.",
        buyingGuide   = "ابحث على CarnoSyn® Beta-Alanine على العلبة، ده الشكل المدروس. البودرة الخام من Bulk أرخص بكتير وبنفس الفاعلية.\n\nالسوق المصري:\nMyprotein Beta-Alanine Powder، أرخص خيار\nNow Foods Beta-Alanine، كبسولات أسهل في الجرعة\nجوه أي Pre-Workout كويس (C4, Ghost, Gorilla Mode)\n\nخد الجرعة مقسمة على 2-3 مرات في اليوم لتقليل التنميل.",
        cycleGuide    = "8-12 أسبوع استخدام ثم 4 أسابيع راحة. بعض الدراسات بتقول ما محتاجش توقف لكن الاستراحة بتعيد حساسيتك له."
    )
)

@Composable
fun SupplementsScreen(onBack: () -> Unit = {}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(28.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = OnSurface)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        "Supplements",
                        style = MaterialTheme.typography.displayLarge,
                        color = OnSurface,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "دليل عملي بدون مبالغة",
                        style = MaterialTheme.typography.bodyMedium,
                        color = OnSurfaceVariant
                    )
                }
            }
        }

        item {
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment     = Alignment.Top
                    ) {
                        Icon(Icons.Default.Info, contentDescription = null, tint = Primary, modifier = Modifier.size(16.dp))
                        Text(
                            "الغذاء الأساس دايماً. المكملات بس تكمّل النقص. استشر دكتور قبل أي مكمل لو عندك أي حالة صحية.",
                            style = MaterialTheme.typography.bodySmall,
                            color = OnSurfaceVariant
                        )
                    }
                }
            }
        }

        supplements.forEach { supp ->
            item { SupplementCard(supp) }
        }

        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}

@Composable
private fun SupplementCard(supp: SupplementInfo) {
    var expanded by remember { mutableStateOf(false) }
    val tierColor = Color(supp.tierColor)

    GlassCard(modifier = Modifier.fillMaxWidth()) {
        Column {
            // ── Header (always visible): Arabic name right, tier badge left ──
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment     = Alignment.CenterVertically
                ) {
                    // Arabic name + English name (right side in RTL)
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            supp.nameAr,
                            style      = MaterialTheme.typography.titleMedium,
                            color      = OnSurface,
                            fontWeight = FontWeight.Bold
                        )
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                            Text(
                                supp.name,
                                style = MaterialTheme.typography.labelSmall,
                                color = OnSurfaceVariant
                            )
                        }
                    }
                    // Tier badge (left side in RTL = leading)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(tierColor.copy(alpha = 0.12f))
                                .border(1.dp, tierColor.copy(alpha = 0.35f), RoundedCornerShape(8.dp))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                supp.tier,
                                style      = MaterialTheme.typography.labelSmall,
                                color      = tierColor,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Icon(
                            if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint     = OnSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            // ── Expanded: Arabic name + summary + all details ──
            AnimatedVisibility(
                visible = expanded,
                enter   = expandVertically(),
                exit    = shrinkVertically()
            ) {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    Column(modifier = Modifier.padding(top = 14.dp)) {
                        HorizontalDivider(color = Color.White.copy(alpha = 0.07f))
                        Spacer(modifier = Modifier.height(12.dp))

                        // Summary
                        Text(
                            supp.summary,
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(14.dp))

                        SupplementRow("هل يستحق؟", supp.worthIt, Primary)
                        Spacer(modifier = Modifier.height(10.dp))
                        SupplementRow("الجرعة", supp.dose)
                        Spacer(modifier = Modifier.height(10.dp))
                        SupplementRow("التوقيت", supp.timing)
                        Spacer(modifier = Modifier.height(10.dp))
                        SupplementRow("إمتى تحتاجه", supp.whenNeeded)
                        Spacer(modifier = Modifier.height(10.dp))
                        SupplementRow("إمتى ملوش لازمة", supp.whenNotNeeded)
                        Spacer(modifier = Modifier.height(10.dp))
                        SupplementRow("من الأكل", supp.fromFood)

                        if (supp.warnings.isNotBlank()) {
                            Spacer(modifier = Modifier.height(12.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFFFB347).copy(alpha = 0.08f))
                                    .border(1.dp, Color(0xFFFFB347).copy(alpha = 0.25f), RoundedCornerShape(8.dp))
                                    .padding(10.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment     = Alignment.Top
                                ) {
                                    Icon(Icons.Default.Warning, contentDescription = null, tint = Color(0xFFFFB347), modifier = Modifier.size(14.dp))
                                    Text(supp.warnings, style = MaterialTheme.typography.bodySmall, color = OnSurfaceVariant)
                                }
                            }
                        }

                        // ── Buying Guide ──────────────────────────────────────
                        if (supp.buyingGuide.isNotBlank()) {
                            Spacer(modifier = Modifier.height(14.dp))
                            HorizontalDivider(color = Color.White.copy(alpha = 0.07f))
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(Icons.Default.ShoppingCart, null, tint = Primary, modifier = Modifier.size(13.dp))
                                Text("إيه تشتري؟",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Primary,
                                    fontWeight = FontWeight.Bold)
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(supp.buyingGuide,
                                style = MaterialTheme.typography.bodySmall,
                                color = OnSurfaceVariant)
                        }

                        // ── Cycle Guide ────────────────────────────────────────
                        if (supp.cycleGuide.isNotBlank()) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Primary.copy(alpha = 0.06f))
                                    .border(1.dp, Primary.copy(alpha = 0.18f), RoundedCornerShape(8.dp))
                                    .padding(10.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Icon(Icons.Default.Refresh, null, tint = Primary, modifier = Modifier.size(13.dp))
                                    Column {
                                        Text("دورة الاستخدام",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = Primary, fontWeight = FontWeight.Bold)
                                        Spacer(Modifier.height(3.dp))
                                        Text(supp.cycleGuide,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = OnSurfaceVariant)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SupplementRow(label: String, value: String, labelColor: Color = Primary) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment     = Alignment.Top
    ) {
        Text(
            "$label:",
            style     = MaterialTheme.typography.labelSmall,
            color     = labelColor,
            fontWeight = FontWeight.Bold,
            modifier  = Modifier.width(80.dp)
        )
        Text(value, style = MaterialTheme.typography.bodyMedium, color = OnSurface, modifier = Modifier.weight(1f))
    }
}
