package com.example.data

data class FoodItem(
    val id: String,
    val name: String,       // English Name
    val nameAr: String,     // Arabic Name
    val category: String,
    val calories: Int,      // per 100g
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val fiber: Float = 0f,
    val sugar: Float = 0f,
    val iron: Float = 0f,   // mg
    val calcium: Float = 0f,// mg
    val servingSizeGrams: Float = 100f
)

object EgyptianFoodDatabase {
    val foods = listOf(

        // ═══════════════════════════════════════════════════════════
        // 🥚 EGGS & EGG DISHES (بيض وأكلات البيض)
        // ═══════════════════════════════════════════════════════════
        FoodItem("egg1",  "Whole Egg (Raw)",              "بيضة كاملة (نيئة)",         "Egg",     143, 13f,  1f,   10f),
        FoodItem("egg2",  "Whole Egg (Boiled)",            "بيضة مسلوقة",               "Egg",     155, 13f,  1.1f, 11f),
        FoodItem("egg3",  "Egg White (Raw)",               "بياض البيض",                "Egg",      52, 11f,  0.7f, 0.2f),
        FoodItem("egg4",  "Egg Yolk",                      "صفار البيض",                "Egg",     322, 16f,  3.6f, 27f,  iron=2.7f),
        FoodItem("egg5",  "Fried Egg (with oil)",          "بيضة مقلية بالزيت",         "Egg",     196, 14f,  0.4f, 15f),
        FoodItem("egg6",  "Scrambled Eggs",                "بيض مخفوق",                 "Egg",     149, 10f,  1.6f, 11f),
        FoodItem("egg7",  "Quail Eggs (Boiled)",           "بيض سمان مسلوق",            "Egg",     158, 13f,  0.4f, 11f),
        FoodItem("egg8",  "Shakshuka (2 eggs)",            "شكشوكة (بيضتين)",           "Egg",     118,  9f,   6f,   7f),
        FoodItem("egg9",  "Shakshuka with Cheese",         "شكشوكة بالجبنة",            "Egg",     138, 10f,   5f,   9f),
        FoodItem("egg10", "Shakshuka with Sausage",        "شكشوكة بالسجق",             "Egg",     155, 11f,   6f,  10f),
        FoodItem("egg11", "Plain Omelette (2 eggs)",       "أومليت سادة (بيضتين)",      "Egg",     185, 14f,   1f,  14f),
        FoodItem("egg12", "Vegetable Omelette",            "أومليت بالخضار",            "Egg",     170, 13f,   4f,  11f),
        FoodItem("egg13", "Egg with Cheese Omelette",      "أومليت بالجبنة",            "Egg",     220, 16f,   2f,  16f),
        FoodItem("egg14", "Eggs with Pastrami (Basturma)", "بيض بالبسطرمة",             "Egg",     210, 18f,   1f,  15f, iron=2f),
        FoodItem("egg15", "Eggs with Tomato & Peppers",    "بيض بالطماطم والفلفل",      "Egg",     145, 11f,   6f,   9f),

        // ═══════════════════════════════════════════════════════════
        // 🥩 MEAT & POULTRY (لحوم ودواجن)
        // ═══════════════════════════════════════════════════════════
        FoodItem("m1",  "Chicken Breast (Grilled)",    "صدر دجاج مشوي",             "Protein", 165, 31f,  0f,    3.6f),
        FoodItem("m2",  "Chicken Thigh (Cooked)",      "ورك دجاج مطهي",             "Protein", 209, 26f,  0f,   10.9f),
        FoodItem("m3",  "Chicken Wings (Grilled)",     "أجنحة دجاج مشوية",          "Protein", 203, 24f,  0f,   11f),
        FoodItem("m4",  "Whole Chicken (Roasted)",     "فراخ كاملة مشوية",          "Protein", 215, 25f,  0f,   12f),
        FoodItem("m5",  "Beef (Lean, Cooked)",         "لحم بقري صافي مطهي",        "Protein", 250, 26f,  0f,   15f,  iron=2.6f),
        FoodItem("m6",  "Kofta (Grilled)",             "كفتة مشوية",                "Protein", 240, 20f,  4f,   16f,  iron=2f),
        FoodItem("m7",  "Liver (Beef/Alexandrian)",    "كبدة اسكندراني",            "Protein", 190, 29f,  5f,    5f,  iron=6.5f),
        FoodItem("m8",  "Lamb (Cooked)",               "لحم ضاني مطهي",             "Protein", 258, 25f,  0f,   17f,  iron=1.8f),
        FoodItem("m9",  "Minced Meat (Beef)",          "لحم مفروم بقري",            "Protein", 215, 21f,  0f,   14f),
        FoodItem("m10", "Turkey Breast (Cooked)",      "صدر ديك رومي مطهي",         "Protein", 135, 30f,  0f,    1f),
        FoodItem("m11", "Duck (Cooked)",               "بط مطهي",                   "Protein", 337, 19f,  0f,   28f),
        FoodItem("m12", "Rabbit (Cooked)",             "أرانب مطهية",               "Protein", 197, 29f,  0f,    8f),
        FoodItem("m13", "Veal (Cooked)",               "لحم عجل مطهي",              "Protein", 196, 30f,  0f,    7f,  iron=1.1f),
        FoodItem("m14", "Chicken Liver",               "كبدة دجاج",                 "Protein", 172, 26f,  0.7f,  6f,  iron=9f),
        FoodItem("m15", "Hawawshi",                    "حواوشي",                    "Mixed",   280, 12f, 25f,   15f),
        FoodItem("m16", "Shawarma Meat (no bread)",    "شاورما لحم بدون خبز",       "Protein", 220, 18f,  5f,   14f),
        FoodItem("m17", "Shawarma Chicken (no bread)", "شاورما دجاج بدون خبز",      "Protein", 190, 22f,  4f,   10f),

        // ═══════════════════════════════════════════════════════════
        // 🐟 FISH & SEAFOOD (أسماك ومأكولات بحرية)
        // ═══════════════════════════════════════════════════════════
        FoodItem("fs1",  "Tuna (Canned, Water)",        "تونة في ماء",              "Protein", 110, 25f,  0f,    1f),
        FoodItem("fs2",  "Tuna (Canned, Oil)",          "تونة في زيت",              "Protein", 190, 24f,  0f,   10f),
        FoodItem("fs3",  "Tuna (Fresh, Cooked)",        "تونة طازجة مطهية",         "Protein", 130, 29f,  0f,    0.6f),
        FoodItem("fs4",  "Salmon (Cooked)",             "سلمون مطهي",               "Protein", 208, 20f,  0f,   13f),
        FoodItem("fs5",  "Sardines (Canned in Oil)",    "سردين في زيت",             "Protein", 208, 25f,  0f,   11f, iron=2.9f, calcium=382f),
        FoodItem("fs6",  "Bolti / Tilapia (Grilled)",   "بلطي مشوي",                "Protein", 128, 26f,  0f,    2.7f),
        FoodItem("fs7",  "Bouri / Mullet (Grilled)",    "بوري مشوي",                "Protein", 172, 24f,  0f,    8f),
        FoodItem("fs8",  "Shrimp (Cooked)",             "جمبري مطهي",               "Protein",  99, 24f,  0.2f,  0.3f),
        FoodItem("fs9",  "Calamari (Grilled)",          "كالاماري مشوي",            "Protein",  92, 16f,  3f,    1.4f),
        FoodItem("fs10", "Mackerel (Cooked)",           "ماكريل مطهي",              "Protein", 262, 24f,  0f,   17f),
        FoodItem("fs11", "Anchovy (Canned)",            "أنشوجة",                   "Protein", 210, 29f,  0f,    9.7f, iron=4.6f),
        FoodItem("fs12", "Crab (Cooked)",               "كابوريا مطهية",            "Protein",  97, 20f,  0f,    1.5f),
        FoodItem("fs13", "Sea Bass (Cooked)",           "قاروص مطهي",               "Protein", 124, 24f,  0f,    2.5f),

        // ═══════════════════════════════════════════════════════════
        // 🥛 DAIRY & CHEESE (ألبان وجبن)
        // ═══════════════════════════════════════════════════════════
        FoodItem("d1",  "Full Cream Milk",              "لبن كامل الدسم",           "Dairy",    64,  3.4f, 4.8f,  3f,  calcium=120f),
        FoodItem("d2",  "Skimmed Milk",                 "لبن خالي الدسم",           "Dairy",    42,  3.4f, 5f,    0.5f, calcium=120f),
        FoodItem("d3",  "Greek Yogurt",                 "زبادي يوناني",             "Protein",  90,  9f,   4f,    4f),
        FoodItem("d4",  "Plain Yogurt",                 "زبادي سادة",               "Dairy",    60,  4f,   5f,    3f),
        FoodItem("d5",  "Arish Cheese (Quraish)",       "جبنة قريش",               "Protein",  98, 11f,  3f,    4f,  calcium=100f),
        FoodItem("d6",  "Rumi Cheese",                  "جبنة رومي",               "Dairy",   400, 25f,  2f,   32f,  calcium=800f),
        FoodItem("d7",  "Feta Cheese",                  "جبنة فيتا",               "Dairy",   260, 10f,  5f,   22f,  calcium=300f),
        FoodItem("d8",  "White Cheese (Istanbouli)",    "جبنة اسطنبولي",           "Dairy",   280, 12f,  4f,   24f),
        FoodItem("d9",  "Mozzarella",                   "موتزاريلا",               "Dairy",   280, 20f,  2.2f, 22f,  calcium=505f),
        FoodItem("d10", "Cheddar Cheese",               "جبنة شيدر",               "Dairy",   403, 25f,  1.3f, 33f,  calcium=721f),
        FoodItem("d11", "Cream Cheese",                 "كريم تشيز",               "Dairy",   342,  6f,  4f,   34f),
        FoodItem("d12", "Butter",                       "زبدة",                    "Fat",     717,  0.9f, 0.1f, 81f),
        FoodItem("d13", "Ghee (Samn)",                  "سمن بلدي",                "Fat",     900,  0f,   0f,   100f),
        FoodItem("d14", "Whey Protein (1 scoop)",       "بروتين مصل اللبن (سيرفينج)", "Protein", 120, 25f, 3f, 1.5f),

        // ═══════════════════════════════════════════════════════════
        // 🌾 GRAINS, BREAD & CARBS (حبوب وخبز)
        // ═══════════════════════════════════════════════════════════
        FoodItem("c1",  "Baladi Bread",                 "عيش بلدي",                "Carb",    275,  9f,  54f,   1.5f, fiber=5f),
        FoodItem("c2",  "Fino Bread",                   "عيش فينو",                "Carb",    300,  8f,  58f,   2.5f),
        FoodItem("c3",  "Toast Bread (White)",          "توست أبيض",               "Carb",    265,  9f,  49f,   3.2f),
        FoodItem("c4",  "Whole Wheat Bread",            "خبز القمح الكامل",        "Carb",    247, 13f,  41f,   3.4f, fiber=7f),
        FoodItem("c5",  "White Rice (Cooked)",          "أرز أبيض مطهي",           "Carb",    130,  2.7f, 28f,  0.3f),
        FoodItem("c6",  "Brown Rice (Cooked)",          "أرز بني مطهي",            "Carb",    123,  2.6f, 26f,  0.9f, fiber=1.8f),
        FoodItem("c7",  "Pasta (Cooked)",               "مكرونة مطهية",            "Carb",    158,  5.8f, 31f,  0.9f),
        FoodItem("c8",  "Whole Wheat Pasta (Cooked)",   "مكرونة قمح كامل مطهية",   "Carb",    174,  7.5f, 35f,  0.8f, fiber=3.9f),
        FoodItem("c9",  "Oats (Dry)",                   "شوفان جاف",               "Carb",    389, 17f,  66f,   7f,  fiber=10.6f),
        FoodItem("c10", "Oats (Cooked with water)",     "شوفان مطهي بالماء",       "Carb",     71,  2.5f, 12f,   1.5f, fiber=1.7f),
        FoodItem("c11", "Potato (Boiled)",              "بطاطس مسلوقة",            "Carb",     87,  1.9f, 20f,  0.1f, fiber=1.8f),
        FoodItem("c12", "Potato (Baked)",               "بطاطس مشوية",             "Carb",     93,  2.5f, 21f,  0.1f, fiber=2.1f),
        FoodItem("c13", "Sweet Potato (Baked)",         "بطاطا حلوة مشوية",        "Carb",     90,  2f,   21f,  0.2f, fiber=3.3f),
        FoodItem("c14", "French Fries",                 "بطاطس مقلية",             "Fat/Carb",312,  3.4f, 41f,  15f),
        FoodItem("c15", "Corn (Boiled)",                "ذرة مسلوقة",              "Carb",     86,  3.3f, 19f,   1.2f, fiber=2.4f),
        FoodItem("c16", "Couscous (Cooked)",            "كسكسي مطهي",              "Carb",    112,  3.8f, 23f,  0.2f, fiber=1.4f),
        FoodItem("c17", "Quinoa (Cooked)",              "كينوا مطهية",             "Carb",    120,  4.4f, 21f,  1.9f, fiber=2.8f),
        FoodItem("c18", "Bulgur (Cooked)",              "برغل مطهي",               "Carb",     83,  3.1f, 19f,  0.2f, fiber=4.5f),
        FoodItem("c19", "Pancakes (Plain)",             "بان كيك سادة",            "Carb",    227,  6f,   38f,   6f),

        // ═══════════════════════════════════════════════════════════
        // 🫘 LEGUMES (بقوليات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("l1",  "Foul Medames (Plain)",         "فول مدمس سادة",           "Protein", 110,  8f,  20f,  0.5f, fiber=6f, iron=1.5f),
        FoodItem("l2",  "Foul (with Oil)",              "فول بالزيت",              "Protein", 180,  8f,  20f,  7f,  fiber=6f, iron=1.5f),
        FoodItem("l3",  "Lentils (Cooked, Red)",        "عدس أحمر مطهي",           "Protein", 116,  9f,  20f,  0.4f, fiber=7.9f, iron=3.3f),
        FoodItem("l4",  "Lentils (Cooked, Brown)",      "عدس بني مطهي",            "Protein", 116,  9f,  20f,  0.4f, fiber=7.9f, iron=3.3f),
        FoodItem("l5",  "Chickpeas (Cooked)",           "حمص مطهي",                "Protein", 164,  8.9f, 27f, 2.6f, fiber=7.6f, iron=2.9f),
        FoodItem("l6",  "Hummus (Paste)",               "حمص معجون (ديب)",         "Protein", 177,  8f,  14f,  10f, fiber=6f),
        FoodItem("l7",  "White Beans (Cooked)",         "فاصوليا بيضاء مطهية",     "Protein", 139,  9.7f, 25f, 0.5f, fiber=6.3f, iron=3.7f, calcium=90f),
        FoodItem("l8",  "Kidney Beans (Cooked)",        "فاصوليا حمراء مطهية",     "Protein", 127,  8.7f, 23f, 0.5f, fiber=7.4f, iron=2.6f),
        FoodItem("l9",  "Soybeans (Cooked)",            "فول صويا مطهي",           "Protein", 173, 17f,  10f,  9f,  fiber=6f, iron=5.1f, calcium=102f),
        FoodItem("l10", "Peas (Cooked)",                "بسلة مطهية",              "Protein",  84,  5.4f, 15f, 0.4f, fiber=5.7f, iron=1.5f),
        FoodItem("l11", "Falafel (Taameya - Fried)",    "طعمية مقلية",             "Fat/Carb",330, 13f,  31f,  17f, fiber=5f),
        FoodItem("l12", "Lentil Soup",                  "شوربة عدس",               "Carb",     63,  3.8f, 11f, 0.4f, fiber=3.5f),
        FoodItem("l13", "Lupini Beans (Termis)",        "ترمس",                    "Protein", 119, 16f,   9f,  2.4f, fiber=4f),

        // ═══════════════════════════════════════════════════════════
        // 🥗 VEGETABLES (خضروات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("v1",  "Tomato",                       "طماطم",                   "Veg",      18,  0.9f, 3.9f, 0.2f, fiber=1.2f),
        FoodItem("v2",  "Cucumber",                     "خيار",                    "Veg",      15,  0.7f, 3.6f, 0.1f, fiber=0.5f),
        FoodItem("v3",  "Onion",                        "بصلة",                    "Veg",      40,  1.1f, 9.3f, 0.1f, fiber=1.7f),
        FoodItem("v4",  "Garlic",                       "ثوم",                     "Veg",     149,  6.4f, 33f,  0.5f, fiber=2.1f),
        FoodItem("v5",  "Green Pepper",                 "فلفل أخضر",               "Veg",      20,  0.9f, 4.6f, 0.2f, fiber=1.7f),
        FoodItem("v6",  "Red Pepper",                   "فلفل أحمر",               "Veg",      31,  1f,   6f,   0.3f, fiber=2.1f),
        FoodItem("v7",  "Yellow Pepper",                "فلفل أصفر",               "Veg",      27,  1f,   6.3f, 0.2f),
        FoodItem("v8",  "Hot Chili Pepper",             "فلفل حار",                "Veg",      40,  1.9f, 8.8f, 0.4f, fiber=1.5f),
        FoodItem("v9",  "Zucchini (Courgette)",         "كوسة",                    "Veg",      17,  1.2f, 3.1f, 0.3f, fiber=1f),
        FoodItem("v10", "Eggplant",                     "باذنجان",                 "Veg",      25,  1f,   5.9f, 0.2f, fiber=3f),
        FoodItem("v11", "Carrot",                       "جزر",                     "Veg",      41,  0.9f, 10f,  0.2f, fiber=2.8f),
        FoodItem("v12", "Lettuce (Iceberg)",            "خس",                      "Veg",      14,  0.9f, 2.9f, 0.1f, fiber=1.3f),
        FoodItem("v13", "Spinach (Fresh)",              "سبانخ طازجة",             "Veg",      23,  2.9f, 3.6f, 0.4f, fiber=2.2f, iron=2.7f),
        FoodItem("v14", "Spinach (Cooked)",             "سبانخ مطهية",             "Veg",      41,  5.3f, 6.8f, 0.5f, fiber=4.3f, iron=3.6f),
        FoodItem("v15", "Broccoli (Raw)",               "بروكلي طازج",             "Veg",      34,  2.8f, 6.6f, 0.4f, fiber=2.6f, calcium=47f),
        FoodItem("v16", "Cauliflower",                  "قرنبيط",                  "Veg",      25,  1.9f, 5f,   0.3f, fiber=2f),
        FoodItem("v17", "Cabbage (Raw)",                "كرنب طازج",               "Veg",      25,  1.3f, 5.8f, 0.1f, fiber=2.5f),
        FoodItem("v18", "Green Beans",                  "فاصوليا خضراء",           "Veg",      31,  1.8f, 7f,   0.1f, fiber=3.4f),
        FoodItem("v19", "Okra (Bamia)",                 "بامية",                   "Veg",      33,  1.9f, 7.5f, 0.1f, fiber=3.2f),
        FoodItem("v20", "Artichoke (Cooked)",           "أرضي شوكي مطهي",          "Veg",      53,  2.9f, 12f,  0.2f, fiber=10.3f),
        FoodItem("v21", "Mushroom",                     "مشروم",                   "Veg",      22,  3.1f, 3.3f, 0.3f, fiber=1f),
        FoodItem("v22", "Celery",                       "كرفس",                    "Veg",      16,  0.7f, 3f,   0.2f, fiber=1.6f),
        FoodItem("v23", "Parsley (Fresh)",              "بقدونس طازج",             "Veg",      36,  3f,   6.3f, 0.8f, fiber=3.3f, iron=6.2f),
        FoodItem("v24", "Coriander (Fresh)",            "كزبرة طازجة",             "Veg",      23,  2.1f, 3.7f, 0.5f, fiber=2.8f),
        FoodItem("v25", "Beetroot (Cooked)",            "بنجر مطهي",               "Veg",      44,  1.7f, 10f,  0.2f, fiber=2f),
        FoodItem("v26", "Radish",                       "فجل",                     "Veg",      16,  0.7f, 3.4f, 0.1f, fiber=1.6f),
        FoodItem("v27", "Turnip (Cooked)",              "لفت مطهي",                "Veg",      22,  1.1f, 5.1f, 0.1f, fiber=2f),
        FoodItem("v28", "Leek",                         "كراث",                    "Veg",      61,  1.5f, 14f,  0.3f, fiber=1.8f),
        FoodItem("v29", "Spring Onion",                 "بصل أخضر",                "Veg",      32,  1.8f, 7.3f, 0.2f, fiber=2.6f),
        FoodItem("v30", "Molokhia (Cooked)",            "ملوخية مطهية",             "Veg",      45,  2f,   5f,   2f,  fiber=1.5f, iron=2.5f),
        FoodItem("v31", "Pumpkin (Cooked)",             "قرع عسل مطهي",            "Veg",      26,  1f,   6.5f, 0.1f, fiber=0.5f),
        FoodItem("v32", "Watercress",                   "جرجير / رشاد",            "Veg",      11,  2.3f, 1.3f, 0.1f, fiber=0.5f, iron=0.2f),
        FoodItem("v33", "Arugula (Gargeer)",            "جرجير",                   "Veg",      25,  2.6f, 3.7f, 0.7f, fiber=1.6f, iron=1.5f, calcium=160f),
        FoodItem("v34", "Sweet Corn (Canned)",          "ذرة معلبة",               "Veg",      86,  2.9f, 19f,  1.1f, fiber=1.8f),
        FoodItem("v35", "Avocado",                      "أفوكادو",                 "Fat",     160,  2f,   9f,   15f, fiber=7f),
        FoodItem("v36", "Olives (Green)",               "زيتون أخضر",              "Fat",     145,  1f,   3.8f, 15f, fiber=3.3f),
        FoodItem("v37", "Olives (Black)",               "زيتون أسود",              "Fat",     115,  0.8f, 6f,   11f, fiber=3.2f),
        FoodItem("v38", "Potato (Raw)",                 "بطاطس خام",               "Carb",     77,  2f,   17f,  0.1f, fiber=2.2f),
        FoodItem("v39", "Tomato Paste",                 "معجون طماطم",             "Veg",      82,  4.3f, 19f,  0.5f, fiber=4.1f),
        FoodItem("v40", "Dill (Fresh)",                 "شبت طازج",                "Veg",      43,  3.5f, 7f,   1.1f, fiber=2.1f),

        // ═══════════════════════════════════════════════════════════
        // 🍎 FRUITS (فواكه)
        // ═══════════════════════════════════════════════════════════
        FoodItem("fr1",  "Apple",                        "تفاحة",                  "Carb",    52,  0.3f, 14f,  0.2f, fiber=2.4f, sugar=10f),
        FoodItem("fr2",  "Orange",                       "برتقالة",                "Carb",    47,  0.9f, 12f,  0.1f, fiber=2.4f, sugar=9.4f),
        FoodItem("fr3",  "Banana",                       "موز",                    "Carb",    89,  1.1f, 23f,  0.3f, fiber=2.6f, sugar=12f),
        FoodItem("fr4",  "Watermelon",                   "بطيخ",                   "Carb",    30,  0.6f, 7.6f, 0.2f, fiber=0.4f, sugar=6.2f),
        FoodItem("fr5",  "Cantaloupe",                   "شمام",                   "Carb",    34,  0.8f, 8.2f, 0.2f, fiber=0.9f, sugar=7.9f),
        FoodItem("fr6",  "Grapes (Green/Red)",           "عنب",                    "Carb",    67,  0.6f, 17f,  0.4f, fiber=0.9f, sugar=16f),
        FoodItem("fr7",  "Strawberry",                   "فراولة",                 "Carb",    32,  0.7f, 7.7f, 0.3f, fiber=2f,  sugar=4.9f),
        FoodItem("fr8",  "Mango",                        "مانجو",                  "Carb",    60,  0.8f, 15f,  0.4f, fiber=1.6f, sugar=14f),
        FoodItem("fr9",  "Guava",                        "جوافة",                  "Carb",    68,  2.6f, 14f,  1f,  fiber=5.4f),
        FoodItem("fr10", "Pomegranate",                  "رمان",                   "Carb",    83,  1.7f, 19f,  1.2f, fiber=4f),
        FoodItem("fr11", "Dates (Fresh Balah)",          "بلح طازج",               "Carb",   142,  1.3f, 38f,  0.1f, fiber=2.6f, iron=0.9f),
        FoodItem("fr12", "Dates (Dried Tamr)",           "تمر ناشف",               "Carb",   282,  2.5f, 75f,  0.4f, fiber=8f,  iron=0.9f),
        FoodItem("fr13", "Fig (Fresh)",                  "تين طازج",               "Carb",    74,  0.8f, 19f,  0.3f, fiber=2.9f),
        FoodItem("fr14", "Fig (Dried)",                  "تين مجفف",               "Carb",   249,  3.3f, 63f,  0.9f, fiber=9.8f, iron=2.0f, calcium=162f),
        FoodItem("fr15", "Pear",                         "إجاص / كمثرى",           "Carb",    57,  0.4f, 15f,  0.1f, fiber=3.1f),
        FoodItem("fr16", "Peach",                        "خوخ",                    "Carb",    39,  0.9f, 9.5f, 0.3f, fiber=1.5f),
        FoodItem("fr17", "Apricot",                      "مشمش",                   "Carb",    48,  1.4f, 11f,  0.4f, fiber=2f,  iron=0.4f),
        FoodItem("fr18", "Lemon",                        "ليمون",                  "Carb",    29,  1.1f, 9.3f, 0.3f, fiber=2.8f),
        FoodItem("fr19", "Kiwi",                         "كيوي",                   "Carb",    61,  1.1f, 15f,  0.5f, fiber=3f),
        FoodItem("fr20", "Pineapple",                    "أناناس",                 "Carb",    50,  0.5f, 13f,  0.1f, fiber=1.4f),
        FoodItem("fr21", "Mandarin / Tangerine",         "يوسف أفندي / مندرين",    "Carb",    53,  0.8f, 13f,  0.3f, fiber=1.8f),
        FoodItem("fr22", "Grapefruit",                   "جريب فروت",              "Carb",    42,  0.8f, 11f,  0.1f, fiber=1.6f),
        FoodItem("fr23", "Cherry",                       "كرز",                    "Carb",    50,  1f,   12f,  0.3f, fiber=1.6f),
        FoodItem("fr24", "Plum",                         "برقوق",                  "Carb",    46,  0.7f, 11f,  0.3f, fiber=1.4f),
        FoodItem("fr25", "Coconut (Fresh)",              "جوز الهند طازج",         "Fat",    354,  3.3f, 15f,  33f, fiber=9f),
        FoodItem("fr26", "Melon (Honeydew)",             "شمام عسلي",              "Carb",    36,  0.5f, 9f,   0.1f, fiber=0.8f),
        FoodItem("fr27", "Papaya",                       "بابايا",                 "Carb",    43,  0.5f, 11f,  0.3f, fiber=1.7f),
        FoodItem("fr28", "Lychee",                       "ليتشي",                  "Carb",    66,  0.8f, 17f,  0.4f, fiber=1.3f),

        // ═══════════════════════════════════════════════════════════
        // 🥜 NUTS & SEEDS (مكسرات وبذور)
        // ═══════════════════════════════════════════════════════════
        FoodItem("n1",  "Almonds",                       "لوز",                    "Fat",    579, 21f,  22f,  50f, fiber=12.5f),
        FoodItem("n2",  "Walnuts",                       "جوز",                    "Fat",    654, 15f,  14f,  65f, fiber=6.7f),
        FoodItem("n3",  "Cashews",                       "كاجو",                   "Fat",    553, 18f,  30f,  44f, fiber=3.3f),
        FoodItem("n4",  "Pistachios",                    "فستق حلبي",              "Fat",    562, 20f,  28f,  45f, fiber=10.6f),
        FoodItem("n5",  "Peanuts (Roasted)",             "فول سوداني محمص",        "Fat",    567, 26f,  16f,  49f, fiber=8.5f),
        FoodItem("n6",  "Peanut Butter",                 "زبدة الفول السوداني",    "Fat",    588, 25f,  20f,  50f, fiber=6f),
        FoodItem("n7",  "Hazelnuts",                     "بندق",                   "Fat",    628, 15f,  17f,  61f, fiber=9.7f),
        FoodItem("n8",  "Sunflower Seeds",               "بذور دوار الشمس",        "Fat",    584, 21f,  20f,  51f, fiber=8.6f),
        FoodItem("n9",  "Pumpkin Seeds",                 "بذور اليقطين",           "Fat",    559, 30f,  11f,  49f, fiber=6f),
        FoodItem("n10", "Sesame Seeds",                  "سمسم",                   "Fat",    573, 17f,  23f,  50f, fiber=11.8f, calcium=975f, iron=14.6f),
        FoodItem("n11", "Tahini (Sesame Paste)",         "طحينة",                  "Fat",    595, 17f,  21f,  54f, fiber=9.3f, calcium=426f),
        FoodItem("n12", "Flaxseeds",                     "بذور الكتان",            "Fat",    534, 18f,  29f,  42f, fiber=27.3f),
        FoodItem("n13", "Chia Seeds",                    "بذور شيا",               "Fat",    486, 17f,  42f,  31f, fiber=34.4f, calcium=631f),
        FoodItem("n14", "Pine Nuts",                     "صنوبر",                  "Fat",    673, 14f,  13f,  68f, fiber=3.7f),
        FoodItem("n15", "Macadamia Nuts",                "ماكاداميا",              "Fat",    718,  7.9f, 14f,  76f, fiber=8.6f),

        // ═══════════════════════════════════════════════════════════
        // 🫒 OILS & FATS (زيوت ودهون)
        // ═══════════════════════════════════════════════════════════
        FoodItem("oil1", "Olive Oil",                    "زيت زيتون",              "Fat",    884,  0f,   0f,  100f),
        FoodItem("oil2", "Sunflower Oil",                "زيت عباد الشمس",         "Fat",    884,  0f,   0f,  100f),
        FoodItem("oil3", "Corn Oil",                     "زيت ذرة",                "Fat",    884,  0f,   0f,  100f),
        FoodItem("oil4", "Coconut Oil",                  "زيت جوز الهند",          "Fat",    862,  0f,   0f,  100f),
        FoodItem("oil5", "Mayonnaise",                   "مايونيز",                "Fat",    680,  1f,   0.6f, 75f),

        // ═══════════════════════════════════════════════════════════
        // 🍽️ EGYPTIAN DISHES (أكلات مصرية)
        // ═══════════════════════════════════════════════════════════
        FoodItem("eg1",  "Koshary",                      "كشري مصري",              "Carb/Mixed", 160, 5f,  25f,  4f,  fiber=3f),
        FoodItem("eg2",  "Mahshi (Grape Leaves)",        "محشي ورق عنب",           "Carb",   140,  2.5f, 22f,  5f,  fiber=1.5f),
        FoodItem("eg3",  "Mahshi (Zucchini)",            "محشي كوسة",              "Carb",   130,  3f,   18f,  5f),
        FoodItem("eg4",  "Mahshi (Cabbage)",             "محشي كرنب",              "Carb",   130,  2f,   20f,  5f,  fiber=2f),
        FoodItem("eg5",  "Macarona Bechamel",            "مكرونة بشاميل",          "Mixed",  200,  9f,   18f,  10f),
        FoodItem("eg6",  "Fattah (Lamb & Rice)",         "فتة لحمة",               "Mixed",  210,  12f,  25f,  7f),
        FoodItem("eg7",  "Fiteer Meshaltet",             "فطير مشلتت",             "Fat/Carb",420, 6f,  45f,  24f),
        FoodItem("eg8",  "Sago (Rice Pudding)",          "أرز باللبن",             "Carb",   130,  3.5f, 23f,  3f),
        FoodItem("eg9",  "Fattah (Chicken & Rice)",      "فتة دجاج",               "Mixed",  185,  14f,  22f,  4f),
        FoodItem("eg10", "Konafa",                       "كنافة",                  "Carb",   385,  6f,   54f,  17f, sugar=30f),
        FoodItem("eg11", "Om Ali",                       "أم علي",                 "Carb",   320,  7f,   43f,  14f, sugar=25f),
        FoodItem("eg12", "Basbousa",                     "بسبوسة",                 "Carb",   340,  5f,   60f,  10f, sugar=35f),
        FoodItem("eg13", "Mulukhiyah with Chicken",      "ملوخية بالدجاج",         "Mixed",   85,  7f,    6f,  3f),
        FoodItem("eg14", "Torly (Egyptian Veg Stew)",    "طرلي مصري",              "Veg",     80,  3f,   14f,  2f,  fiber=4f),
        FoodItem("eg15", "Kebab (Lamb)",                 "كباب حلة",               "Protein",230, 18f,  4f,   16f),
        FoodItem("eg16", "Hawawshi",                     "حواوشي",                 "Mixed",  280, 12f,  25f,  15f),
        FoodItem("eg17", "Tamiya Sandwich (full)",       "طعمية في عيش",           "Carb",   290,  9f,   38f,  12f),
        FoodItem("eg18", "Ful Sandwich",                 "فول في عيش",             "Protein",260, 10f,  40f,   5f, fiber=7f),
        FoodItem("eg19", "Feteer Saleeq (Cream Fateer)", "فطير صليق بالقشطة",      "Carb",   395,  7f,   48f,  20f),
        FoodItem("eg20", "Shawarma (full sandwich)",     "شاورما كاملة",           "Mixed",  390, 22f,  38f,  16f),
        FoodItem("eg21", "Egyptian Moussaka",            "مسقعة مصرية",            "Veg",    120,  3f,   12f,   7f),

        // ═══════════════════════════════════════════════════════════
        // 🍆 EGGPLANT DISHES (أكلات البتنجان)
        // ═══════════════════════════════════════════════════════════
        FoodItem("bt1",  "Baba Ganoush",                 "بابا غنوج",               "Veg",     88,  2.5f,  8.6f,  5.5f, fiber=3f),
        FoodItem("bt2",  "Grilled Eggplant",             "بتنجان مشوي",             "Veg",     33,  1.5f,  7f,    0.2f, fiber=3f),
        FoodItem("bt3",  "Eggplant in Tomato Sauce",     "بتنجان بالطماطم",         "Veg",     60,  1.5f,  8f,    3f,   fiber=2.5f),
        FoodItem("bt4",  "Eggplant with Garlic & Oil",   "بتنجان بالثوم والزيت",   "Veg",     95,  1.5f,  7f,    6.5f, fiber=3f),
        FoodItem("bt5",  "Fried Eggplant Slices",        "بتنجان مقلي شرايح",       "Veg",    180,  1.8f,  9f,   15f,  fiber=3f),
        FoodItem("bt6",  "Stuffed Eggplant (Mahshi)",    "محشي بتنجان",             "Mixed",  145,  4f,   18f,    6f),
        FoodItem("bt7",  "Moussaka with Meat",           "مسقعة باللحم",            "Mixed",  160,  9f,   10f,    9f),
        FoodItem("bt8",  "Zaalouka (Moroccan Style)",    "زعلوك بالبتنجان",         "Veg",     75,  2f,    8f,    4f),

        // ═══════════════════════════════════════════════════════════
        // 🍳 COOKED MEALS (وجبات مطهية)
        // ═══════════════════════════════════════════════════════════
        FoodItem("cm1", "Grilled Chicken with Veg",      "دجاج مشوي مع خضروات",   "Protein", 180, 27f,   8f,   5f),
        FoodItem("cm2", "Rice with Chicken",             "أرز بالدجاج",            "Mixed",  200, 12f,  28f,   5f),
        FoodItem("cm3", "Rice with Meat",                "أرز باللحمة",            "Mixed",  210, 11f,  27f,   6f),
        FoodItem("cm4", "Grilled Fish (average)",        "سمك مشوي متوسط",         "Protein", 150, 24f,   0f,   5.5f),
        FoodItem("cm5", "Fried Fish (average)",          "سمك مقلي متوسط",         "Protein", 240, 20f,  10f,  14f),
        FoodItem("cm6", "Vegetable Soup",                "شوربة خضار",             "Veg",      40,  1.5f, 8f,   0.5f, fiber=2f),
        FoodItem("cm7", "Chicken Soup",                  "شوربة دجاج",             "Protein",  60,  5f,   5f,   2f),
        FoodItem("cm8", "Tomato Sauce Pasta",            "مكرونة بالصلصة",         "Carb",   160,  5.5f, 30f,   2f),
        FoodItem("cm9", "Bolognese (Meat Sauce Pasta)",  "مكرونة بولونيز",         "Mixed",  210, 10f,  28f,   6f),
        FoodItem("cm10","Grilled Kofta Plate",           "طبق كفتة مشوية",         "Protein", 240, 18f,   6f,  16f),
        FoodItem("cm11","Baked Chicken (1/4)",           "ربع فرخة مشوي",          "Protein", 190, 24f,   0f,  10f),
        FoodItem("cm12","Bamia with Chicken",            "بامية بالدجاج",          "Mixed",    85,  8f,   5f,   3.5f, fiber=2.5f),
        FoodItem("cm13","Bamia with Meat",               "بامية باللحم",           "Mixed",   100,  8f,   5f,   5f,   fiber=2.5f),
        FoodItem("cm14","Mulukhiyah with Meat",          "ملوخية باللحم",          "Mixed",    95,  8f,   6f,   4f),
        FoodItem("cm15","Stuffed Peppers (Mahshi)",      "محشي فلفل",              "Mixed",   120,  4f,  16f,   4f),
        FoodItem("cm16","Lentil Soup",                   "شوربة عدس",              "Protein",  80,  4f,  12f,   1.5f, fiber=3.5f),
        FoodItem("cm17","Chicken with Onion (Braised)",  "فراخ بالبصل",            "Protein", 170, 22f,   5f,   7f),
        FoodItem("cm18","Okra Tagine with Meat",         "طاجن بامية باللحم",      "Mixed",   105,  8f,   8f,   4.5f, fiber=2f),
        FoodItem("cm19","Ful Medames (Bowl, no bread)",  "فول مدمس في طبق",        "Protein", 130,  8f,  17f,   3.5f, fiber=6f),
        FoodItem("cm20","Ful with Tomato & Egg",         "فول بالطماطم والبيض",    "Protein", 155, 11f,  16f,   5f,   fiber=5f),
        FoodItem("cm21","Chicken Liver with Onion",      "كبدة دجاج بالبصل",       "Protein", 180, 23f,   6f,   7f,   iron=8f),
        FoodItem("cm22","Sautéed Vegetables",            "خضار مقلية بالزيت",      "Veg",      80,  2f,   8f,   5f,   fiber=3f),
        FoodItem("cm23","Stuffed Tomatoes",              "طماطم محشية",            "Mixed",   110,  4f,  14f,   4f),
        FoodItem("cm24","Rice with Vermicelli",          "أرز بالشعيرية",          "Carb",    160,  3f,  33f,   2f),
        FoodItem("cm25","Freekeh with Chicken",          "فريكة بالدجاج",          "Mixed",   195, 14f,  24f,   4.5f, fiber=4f),

        // ═══════════════════════════════════════════════════════════
        // 🧁 SWEETS & DESSERTS (حلويات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("sw1",  "Halawa (Tahini Halva)",        "حلاوة طحينية",           "Snack",  469,  8f,   60f,  22f, fiber=4f),
        FoodItem("sw2",  "Honey",                        "عسل",                    "Carb",   304,  0.3f, 82f,  0f,  sugar=82f),
        FoodItem("sw3",  "Dark Chocolate (70%+)",        "شيكولاتة داكنة 70%+",   "Snack",  598,  8f,   46f,  43f, fiber=11f),
        FoodItem("sw4",  "Milk Chocolate",               "شيكولاتة بالحليب",       "Snack",  535,  8f,   60f,  30f, sugar=52f),
        FoodItem("sw5",  "Ice Cream (Vanilla, 1 scoop)", "آيس كريم فانيليا",       "Snack",  207,  3.5f, 24f,  11f, sugar=21f),
        FoodItem("sw6",  "Jam (Mixed Fruit)",            "مربى فاكهة",             "Carb",   250,  0.5f, 63f,  0.1f, sugar=56f),
        FoodItem("sw7",  "Molasses (Assal Aswed)",       "عسل أسود",               "Carb",   290,  0f,   75f,  0.1f, iron=4.7f, calcium=205f),

        // ═══════════════════════════════════════════════════════════
        // 🥤 BEVERAGES (مشروبات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("bv1",  "Tea (Plain, no sugar)",        "شاي سادة بدون سكر",      "Carb",     1,  0f,    0.4f, 0f),
        FoodItem("bv2",  "Coffee (Black, no sugar)",     "قهوة سادة بدون سكر",     "Carb",     2,  0.3f, 0f,   0f),
        FoodItem("bv3",  "Orange Juice (Fresh)",         "عصير برتقال طبيعي",      "Carb",    45,  0.7f, 10.4f, 0.2f),
        FoodItem("bv4",  "Sugar (per 1 tsp / 4g)",       "سكر (معلقة صغيرة)",      "Carb",   387,  0f,  100f,  0f,  sugar=100f),
        FoodItem("bv5",  "Whole Milk (1 cup 240ml)",     "كوب لبن كامل الدسم",     "Dairy",   149,  8f,   11.7f, 8f, calcium=276f),

        // ═══════════════════════════════════════════════════════════
        // 🍿 SNACKS & PACKAGED FOODS (سناكس)
        // ═══════════════════════════════════════════════════════════
        FoodItem("sn1",  "Bake Rolz",                    "بيك رولز",               "Snack",  412, 11f,  70f,  10f),
        FoodItem("sn2",  "Lays / Chipsy",                "شيبسي / ليز",            "Snack",  536,  6f,  53f,  35f),
        FoodItem("sn3",  "Doritos",                      "دوريتوس",                "Snack",  500,  7f,  62f,  26f),
        FoodItem("sn4",  "Bisco Misr (Date)",            "بسكويت بسكو مصر عجوة",   "Snack",  430,  5f,  75f,  12f, sugar=30f),
        FoodItem("sn5",  "Rice Crackers (plain)",        "بسكويت الأرز",           "Snack",  388,  7.6f, 82f,  2.8f),
        FoodItem("sn6",  "Popcorn (Air-popped)",         "فشار بدون زيت",          "Snack",  387, 13f,  78f,   4.5f, fiber=14.5f),
        FoodItem("sn7",  "Molto Cake",                   "مولتو",                  "Snack",  450,  6f,  55f,  23f, sugar=20f),

        // ═══════════════════════════════════════════════════════════
        // 🧂 CONDIMENTS & SAUCES
        // ═══════════════════════════════════════════════════════════
        FoodItem("co1",  "Ketchup",                      "كاتشب",                  "Carb",   100,  1.7f, 25f,  0.1f, sugar=22f),
        FoodItem("co2",  "Mustard (Yellow)",             "مستردة صفراء",           "Carb",    66,  4.4f, 6.8f, 4f),
        FoodItem("co3",  "Soy Sauce",                    "صوص الصويا",             "Carb",    53,  8.1f, 4.9f, 0.6f),

        // ═══════════════════════════════════════════════════════════
        // 🥤 PROTEIN & FITNESS FOODS
        // ═══════════════════════════════════════════════════════════
        FoodItem("pf1",  "Protein Bar (avg)",            "بروتين بار متوسط",       "Protein", 360, 30f,  30f,  10f, fiber=5f),
        FoodItem("pf2",  "Creatine (5g serving)",        "كرياتين سيرفينج",        "Supplement", 0, 0f, 0f, 0f),
        FoodItem("pf3",  "Oats with Milk Protein Bowl",  "بول شوفان بالحليب",      "Mixed",  320, 18f,  45f,   7f, fiber=5f),

        // ═══════════════════════════════════════════════════════════
        // 🐟 TUNA — كل الأنواع والشركات
        // ═══════════════════════════════════════════════════════════
        FoodItem("tn1",  "Tuna in Water (Ghazala)",       "تونة غزالة في ماء (180ج)",      "Protein", 132, 29f, 0f, 1f),
        FoodItem("tn2",  "Tuna in Sunflower Oil (Ghazala)","تونة غزالة في زيت عباد الشمس", "Protein", 198, 26f, 0f, 10f),
        FoodItem("tn3",  "Tuna in Water (Americana)",     "تونة أمريكانا في ماء (185ج)",   "Protein", 138, 30f, 0f, 1.5f),
        FoodItem("tn4",  "Tuna in Oil (Americana)",       "تونة أمريكانا في زيت (185ج)",   "Protein", 210, 26f, 0f, 11f),
        FoodItem("tn5",  "Tuna in Olive Oil (Americana)", "تونة أمريكانا زيت زيتون",       "Protein", 218, 26f, 0f, 12f),
        FoodItem("tn6",  "Tuna Salad Spread (Americana)", "تونة أمريكانا سبريد سلطة",      "Protein", 175, 22f, 3f, 9f),
        FoodItem("tn7",  "Tuna with Corn (Al Kana)",      "تونة القنا بالذرة",              "Protein", 155, 20f, 5f, 6f),
        FoodItem("tn8",  "Tuna with Vegetables (Al Kana)","تونة القنا بالخضار",             "Protein", 148, 19f, 4f, 6f),
        FoodItem("tn9",  "Tuna in Water (Al Kana)",       "تونة القنا في ماء (160ج)",       "Protein", 124, 27f, 0f, 1f),
        FoodItem("tn10", "Tuna Fillet Light (Ghazala)",   "تونة غزالة شرائح لايت",          "Protein", 118, 26f, 0f, 0.8f),
        FoodItem("tn11", "Tuna Chunk Light in Water",     "تونة قطع لايت في ماء (عام)",     "Protein", 109, 25f, 0f, 0.5f),
        FoodItem("tn12", "Tuna in Tomato Sauce",          "تونة بصلصة الطماطم",             "Protein", 145, 20f, 4f, 5f),
        FoodItem("tn13", "Sardines in Water (Ghazala)",   "سردين غزالة في ماء",             "Protein", 185, 25f, 0f, 9f),
        FoodItem("tn14", "Sardines in Oil (Ghazala)",     "سردين غزالة في زيت",             "Protein", 208, 24f, 0f, 12f),
        FoodItem("tn15", "Sardines in Tomato (Americana)","سردين أمريكانا بالطماطم",        "Protein", 165, 20f, 3f, 8f),
        FoodItem("tn16", "Mackerel in Brine",             "ماكريل في محلول ملحي",           "Protein", 180, 22f, 0f, 9.5f),

        // ═══════════════════════════════════════════════════════════
        // 🍟 CHIPS — شيبسي / ليز / دوريتوس بكل النكهات
        // ═══════════════════════════════════════════════════════════
        FoodItem("ch1",  "Chipsy Ketchup (23g bag)",      "شيبسي كاتشب (كيس 23ج)",         "Snack", 540, 5.5f, 55f, 33f),
        FoodItem("ch2",  "Chipsy Sour Cream (23g)",       "شيبسي قشطة حامض (23ج)",         "Snack", 545, 5.5f, 53f, 35f),
        FoodItem("ch3",  "Chipsy BBQ (23g)",              "شيبسي باربكيو (23ج)",            "Snack", 538, 5.5f, 54f, 33.5f),
        FoodItem("ch4",  "Chipsy Salt & Vinegar",         "شيبسي ملح وخل",                  "Snack", 535, 5.5f, 55f, 32.5f),
        FoodItem("ch5",  "Chipsy Cheese (23g)",           "شيبسي جبنة (23ج)",               "Snack", 542, 5.8f, 54f, 33.5f),
        FoodItem("ch6",  "Lays Classic (25g)",            "ليز كلاسيك (25ج)",               "Snack", 536, 6f,   52f, 35f),
        FoodItem("ch7",  "Lays Paprika (25g)",            "ليز بابريكا (25ج)",              "Snack", 540, 6f,   53f, 35f),
        FoodItem("ch8",  "Doritos Nacho Cheese",          "دوريتوس ناتشو جبنة",             "Snack", 500, 7f,   62f, 25f),
        FoodItem("ch9",  "Doritos Hot & Spicy",           "دوريتوس حار",                    "Snack", 500, 7f,   62f, 25f),
        FoodItem("ch10", "Pringles Original (40g)",       "برينجلز أصلي (40ج)",             "Snack", 543, 5.5f, 52f, 35f),
        FoodItem("ch11", "Pringles Sour Cream & Onion",   "برينجلز قشطة بصل",               "Snack", 548, 5.5f, 52f, 36f),
        FoodItem("ch12", "Doritos Cool Ranch",            "دوريتوس كول رانش",               "Snack", 500, 7f,   62f, 25f),
        FoodItem("ch13", "Chipsy Big Bag (57g)",          "شيبسي كيس كبير (57ج)",          "Snack", 538, 5.5f, 54f, 33f),
        FoodItem("ch14", "Cheese Puffs (Bake Rolz)",      "بيك رولز جبنة (مكسرات)",        "Snack", 412, 11f,  70f, 10f),

        // ═══════════════════════════════════════════════════════════
        // 🧃 JUICE — عصائر بكل الماركات
        // ═══════════════════════════════════════════════════════════
        FoodItem("jc1",  "Juhayna Orange Juice (250ml)",  "جهينة عصير برتقال (250مل)",     "Carb", 120, 0.5f, 28f, 0f, sugar=26f),
        FoodItem("jc2",  "Juhayna Mango Juice (250ml)",   "جهينة عصير مانجو (250مل)",      "Carb", 140, 0.5f, 33f, 0f, sugar=30f),
        FoodItem("jc3",  "Juhayna Mixed Fruit (250ml)",   "جهينة فاكهة متنوعة (250مل)",    "Carb", 130, 0.5f, 30f, 0f, sugar=28f),
        FoodItem("jc4",  "Enjoy Orange (250ml)",          "إنجوي برتقال (250مل)",           "Carb", 115, 0.5f, 27f, 0f, sugar=25f),
        FoodItem("jc5",  "Enjoy Mango (250ml)",           "إنجوي مانجو (250مل)",            "Carb", 130, 0.5f, 31f, 0f, sugar=28f),
        FoodItem("jc6",  "Enjoy Guava (250ml)",           "إنجوي جوافة (250مل)",            "Carb", 125, 0.5f, 29f, 0f, sugar=26f),
        FoodItem("jc7",  "Tropicana Orange (200ml)",      "تروبيكانا برتقال (200مل)",       "Carb", 90,  0.7f, 20f, 0.2f, sugar=18f),
        FoodItem("jc8",  "Minute Maid Orange (200ml)",    "مينيت ميد برتقال (200مل)",       "Carb", 88,  0.5f, 21f, 0f, sugar=19f),
        FoodItem("jc9",  "Pepsi (330ml can)",             "بيبسي (علبة 330مل)",             "Carb", 143, 0f,   36f, 0f, sugar=36f),
        FoodItem("jc10", "Coca Cola (330ml can)",         "كوكاكولا (علبة 330مل)",          "Carb", 139, 0f,   35f, 0f, sugar=35f),
        FoodItem("jc11", "Pepsi Zero (330ml)",            "بيبسي زيرو (330مل)",             "Carb",   1, 0f,   0f,  0f),
        FoodItem("jc12", "Mirinda Orange (330ml)",        "ميرندا برتقال (330مل)",          "Carb", 155, 0f,   39f, 0f, sugar=39f),
        FoodItem("jc13", "7Up (330ml)",                   "سفن أب (330مل)",                 "Carb", 140, 0f,   35f, 0f, sugar=35f),
        FoodItem("jc14", "Sprite (330ml)",                "سبريت (330مل)",                  "Carb", 140, 0f,   35f, 0f, sugar=35f),
        FoodItem("jc15", "Juhayna Mango Nectar 1L",       "جهينة مانجو نكتار (1 لتر)",     "Carb", 60,  0.3f, 14f, 0f, sugar=13f),
        FoodItem("jc16", "Vitrac Apricot Juice (200ml)",  "فيتراك مشمش (200مل)",           "Carb", 92,  0.5f, 22f, 0f, sugar=20f),

        // ═══════════════════════════════════════════════════════════
        // 🥛 DAIRY — ألبان ومنتجات
        // ═══════════════════════════════════════════════════════════
        FoodItem("dy1",  "Juhayna Full Fat Milk (200ml)", "جهينة لبن كامل الدسم (200مل)",  "Dairy", 120, 6.4f, 9.4f, 6.4f, calcium=220f),
        FoodItem("dy2",  "Juhayna Low Fat Milk (200ml)",  "جهينة لبن قليل الدسم (200مل)",  "Dairy",  80, 6.4f, 9.4f, 1.8f, calcium=220f),
        FoodItem("dy3",  "Lamar Milk Full Fat (200ml)",   "لامار لبن كامل (200مل)",         "Dairy", 124, 6.6f, 9.8f, 6.8f, calcium=230f),
        FoodItem("dy4",  "Kiri Cheese Triangle (18g)",    "جبنة كيري مثلثة (18ج)",         "Dairy",  48, 2.5f, 1.8f, 3.6f, calcium=90f),
        FoodItem("dy5",  "Kraft Cheddar Slice (25g)",     "شريحة كرافت شيدر (25ج)",        "Dairy",  70, 4f,   1f,   5.5f, calcium=130f),
        FoodItem("dy6",  "Domiati Cheese White (100g)",   "جبنة دومياط بيضاء (100ج)",      "Dairy", 255, 16f,  1f,  20f, calcium=510f),
        FoodItem("dy7",  "Rumi Cheese (100g)",            "جبنة رومي (100ج)",               "Dairy", 355, 26f,  1f,  28f, calcium=810f),
        FoodItem("dy8",  "Labneh (100g)",                 "لبنة (100ج)",                    "Dairy", 100, 5.5f, 4f,  7f, calcium=130f),
        FoodItem("dy9",  "Activia Yogurt (120g)",         "أكتيفيا زبادي (120ج)",           "Dairy",  90, 4f,  11f,  2.5f, calcium=145f),
        FoodItem("dy10", "Danone Strawberry Yogurt",      "دانون فراولة (120ج)",            "Dairy", 105, 3.5f, 17f, 2.5f, sugar=14f),

        // ═══════════════════════════════════════════════════════════
        // 🍞 BREAD & BAKERY — خبز ومخبوزات
        // ═══════════════════════════════════════════════════════════
        FoodItem("br1",  "Egyptian Baladi Bread (round)", "عيش بلدي (رغيف كامل)",          "Carb", 165, 6f,   34f, 1.5f, fiber=4f),
        FoodItem("br2",  "French Baguette Toast Slice",   "توست أبيض شريحة (25ج)",         "Carb",  66, 2.3f, 12f, 0.8f),
        FoodItem("br3",  "Whole Wheat Toast Slice (30g)", "توست قمح كامل شريحة (30ج)",     "Carb",  75, 3.2f, 13f, 1.2f, fiber=2.5f),
        FoodItem("br4",  "Fino Bread (1 roll 50g)",       "خبز فينو رول (50ج)",            "Carb", 145, 4.5f, 27f, 2.5f),
        FoodItem("br5",  "Semit (Sesame Bread Ring)",     "سميط (كعكة السمسم)",            "Carb", 290, 9f,   52f, 5.5f),
        FoodItem("br6",  "Pita Bread (Aish Shami 60g)",   "خبز شامي / بيتا (60ج)",        "Carb", 165, 5.5f, 33f, 1f, fiber=2f),
        FoodItem("br7",  "Toast Fino White (30g slice)",  "توست فينو أبيض (شريحة 30ج)",   "Carb",  82, 2.5f, 15f, 1.2f),

        // ═══════════════════════════════════════════════════════════
        // ☕ COFFEE & HOT DRINKS (قهوة ومشروبات ساخنة)
        // ═══════════════════════════════════════════════════════════
        FoodItem("cf1",  "Nescafe Classic 1 tsp (2g)",    "نسكافيه كلاسيك (معلقة 2ج)",    "Carb",   8,  0.4f, 1.4f, 0.2f),
        FoodItem("cf2",  "Nescafe Gold 1 tsp (2g)",       "نسكافيه جولد (معلقة 2ج)",       "Carb",   8,  0.4f, 1.5f, 0.1f),
        FoodItem("cf3",  "Nescafe 3in1 Sachet (17g)",     "نسكافيه 3 في 1 (ساشيه 17ج)",   "Carb",  74,  0.8f, 12f,  2.4f, sugar=10f),
        FoodItem("cf4",  "Nescafe Original Sachet (20g)", "نسكافيه أوريجينال ساشيه (20ج)", "Carb",  89,  1f,   15f,  2.8f, sugar=13f),
        FoodItem("cf5",  "Turkish Coffee (1 cup, no sugar)","قهوة تركي بدون سكر",          "Carb",  11,  0.6f,  2f,  0.4f),
        FoodItem("cf6",  "Espresso (1 shot, no sugar)",   "إسبريسو بدون سكر",              "Carb",   5,  0.3f,  0.8f, 0.1f),
        FoodItem("cf7",  "Cappuccino with Full Milk",     "كابتشينو بلبن كامل",             "Dairy", 80,  4f,    8f,   3f),
        FoodItem("cf8",  "Milo (2 tbsp / 20g)",           "ميلو (2 معلقة كبيرة 20ج)",      "Carb",  75,  1.5f, 15f,  0.8f, sugar=9f),
        FoodItem("cf9",  "Ovomaltine (20g)",               "أوفالتين (20ج)",                "Carb",  77,  1.8f, 15f,  1.2f, calcium=60f),
        FoodItem("cf10", "Hot Chocolate Cadbury (20g)",   "شيكولاتة ساخنة كادبوري (20ج)",  "Carb",  77,  1f,   16f,  1.4f, sugar=14f),
        FoodItem("cf11", "Lipton Yellow Label Tea Bag",   "شاي ليبتون أصفر (كيس)",         "Carb",   2,  0f,    0.4f, 0f),
        FoodItem("cf12", "Karak Chai (with milk & sugar)","شاي كرك بالحليب والسكر",        "Dairy", 110, 2.5f,  18f, 3f, sugar=15f),

        // ═══════════════════════════════════════════════════════════
        // 🍫 CHOCOLATE & CANDY (شيكولاتة وحلوى)
        // ═══════════════════════════════════════════════════════════
        FoodItem("choc1", "KitKat 2-finger (20.7g)",      "كيت كات إصبعين (20.7ج)",       "Snack", 107, 1.5f, 13.5f, 5.5f, sugar=11f),
        FoodItem("choc2", "KitKat 4-finger (41.5g)",      "كيت كات 4 أصابع (41.5ج)",      "Snack", 214, 3f,   27f,  11f,  sugar=22f),
        FoodItem("choc3", "Snickers Bar (50g)",            "سنيكرز (50ج)",                  "Snack", 245, 4f,   32f,  12f,  sugar=27f),
        FoodItem("choc4", "Twix Bar (50g)",                "تويكس (50ج)",                   "Snack", 250, 2.5f, 33f,  12f,  sugar=25f),
        FoodItem("choc5", "Mars Bar (51g)",                "مارس (51ج)",                    "Snack", 228, 2.5f, 34f,  9.5f, sugar=30f),
        FoodItem("choc6", "Bounty (57g)",                  "باونتي (57ج)",                  "Snack", 283, 2.5f, 35f,  15f,  sugar=30f),
        FoodItem("choc7", "Kinder Bueno (43g)",            "كيندر بوينو (43ج)",             "Snack", 233, 4f,   24f,  13f,  sugar=20f),
        FoodItem("choc8", "Galaxy Smooth Milk (42g)",      "جالاكسي ميلك (42ج)",            "Snack", 225, 3f,   25f,  12.5f, sugar=23f),
        FoodItem("choc9", "Nutella (20g / 1 tbsp)",        "نوتيلا (20ج / معلقة كبيرة)",   "Snack", 110, 1.3f, 12f,  6.5f, sugar=11f),
        FoodItem("choc10","Cadbury Dairy Milk (45g)",      "كادبوري ديري ميلك (45ج)",       "Snack", 234, 3.5f, 26f,  13f,  sugar=24f),
        FoodItem("choc11","M&Ms Peanut (45g)",             "إم آند إم فول سوداني (45ج)",    "Snack", 220, 5f,   25f,  11f,  sugar=21f),
        FoodItem("choc12","Ferrero Rocher (1 piece 12.5g)","فيريرو روشيه (حبة واحدة)",      "Snack",  73, 1.3f,  6.3f, 4.8f, sugar=5.5f),

        // ═══════════════════════════════════════════════════════════
        // 🥣 CEREAL (حبوب الإفطار)
        // ═══════════════════════════════════════════════════════════
        FoodItem("cer1", "Kellogg's Corn Flakes (30g)",   "كيلوجز كورن فليكس (30ج)",      "Carb", 113, 2.4f, 26f,  0.3f, fiber=0.9f),
        FoodItem("cer2", "Kellogg's Special K (30g)",     "كيلوجز سبيشل كاي (30ج)",        "Carb", 114, 4f,   23f,  0.5f, fiber=1.5f),
        FoodItem("cer3", "Kellogg's Crunchy Nut (30g)",   "كيلوجز كرانشي نت (30ج)",        "Carb", 120, 2f,   25f,  2f,   fiber=0.6f, sugar=10f),
        FoodItem("cer4", "Fitness Cereal Nestlé (30g)",   "نستله فيتنس (30ج)",              "Carb", 112, 3f,   23f,  0.8f, fiber=2f),
        FoodItem("cer5", "Honey Nut Cheerios (30g)",      "هوني نت شيريوز (30ج)",           "Carb", 115, 3f,   23f,  1.5f, fiber=2f,  sugar=9f),
        FoodItem("cer6", "Frosties (30g)",                "فروستيز (30ج)",                  "Carb", 113, 1.5f, 26f,  0.2f, sugar=12f),
        FoodItem("cer7", "Granola Plain (40g)",            "جرانولا سادة (40ج)",             "Carb", 183, 4f,   28f,  6f,   fiber=2.5f),
        FoodItem("cer8", "Granola with Honey & Nuts (40g)","جرانولا عسل ومكسرات (40ج)",     "Carb", 198, 4.5f, 30f,  7.5f, fiber=2.5f, sugar=10f),

        // ═══════════════════════════════════════════════════════════
        // 🥩 DELI MEATS & COLD CUTS (مسلوق وشرايح بارد)
        // ═══════════════════════════════════════════════════════════
        FoodItem("dl1",  "Turkey Mortadella (100g)",      "مرتديلا تركي (100ج)",           "Protein", 165, 16f,  2f,  10f),
        FoodItem("dl2",  "Chicken Mortadella (100g)",     "مرتديلا دجاج (100ج)",           "Protein", 148, 14f,  3f,   9f),
        FoodItem("dl3",  "Beef Mortadella (100g)",        "مرتديلا لحم بقري (100ج)",       "Protein", 170, 15f,  2f,  11f),
        FoodItem("dl4",  "Beef Pastrami (100g)",          "بسطرمة بقري (100ج)",            "Protein", 175, 22f,  1f,   9f, iron=2.5f),
        FoodItem("dl5",  "Chicken Pastrami (100g)",       "بسطرمة دجاج (100ج)",            "Protein", 155, 20f,  2f,   8f),
        FoodItem("dl6",  "Smoked Turkey Breast (100g)",   "صدر ديك رومي مدخن (100ج)",      "Protein", 112, 22f,  2f,   2f),
        FoodItem("dl7",  "Salami (100g)",                  "سلامي (100ج)",                  "Protein", 385, 22f,  2f,  34f),
        FoodItem("dl8",  "Chicken Sausage (1 piece 50g)", "سجق دجاج (حبة 50ج)",            "Protein", 115, 9f,   2f,   8f),
        FoodItem("dl9",  "Beef Frankfurter (50g)",        "هوت دوج لحم (50ج)",              "Protein", 152, 7f,   3f,  13f),
        FoodItem("dl10", "Koshary Sausage (El Khazan)",   "سجق الخازن\",                    \"Protein\", 230, 11f,  5f,  19f),

        // ═══════════════════════════════════════════════════════════
        // 🍝 PASTA & NOODLES (مكرونة وشعرية)
        // ═══════════════════════════════════════════════════════════
        FoodItem("pa1",  "Indomie Noodles Chicken (75g)", "إندومي دجاج (75ج)",             "Carb",  335, 7f,   47f,  13f),
        FoodItem("pa2",  "Indomie Mi Goreng (85g)",       "إندومي مي جورنج (85ج)",         "Carb",  380, 8f,   52f,  16f),
        FoodItem("pa3",  "Maggi Macaroni & Cheese",       "ماجي مكرونة وجبنة",             "Carb",  352, 10f,  63f,   7f),
        FoodItem("pa4",  "Dry Spaghetti (100g raw)",      "سباغيتي جاف (100ج خام)",        "Carb",  357, 12f,  71f,   1.5f, fiber=2.5f),
        FoodItem("pa5",  "Dry Penne (100g raw)",          "بيني جاف (100ج خام)",           "Carb",  357, 12f,  71f,   1.5f, fiber=2.5f),

        // ═══════════════════════════════════════════════════════════
        // ⚡ ENERGY DRINKS & SPORTS DRINKS (مشروبات طاقة ورياضية)
        // ═══════════════════════════════════════════════════════════
        FoodItem("en1",  "Red Bull Original (250ml)",     "ريد بول (250مل)",               "Carb", 113, 1f,   28f,  0f, sugar=27f),
        FoodItem("en2",  "Red Bull Sugar Free (250ml)",   "ريد بول بدون سكر (250مل)",      "Carb",   8, 0.9f,  1f,   0f),
        FoodItem("en3",  "Monster Original (500ml)",      "مونستر (500مل)",                 "Carb", 190, 0f,   46f,  0f, sugar=46f),
        FoodItem("en4",  "Monster Ultra Zero (500ml)",    "مونستر ألترا زيرو (500مل)",     "Carb",  10, 0f,    2f,   0f),
        FoodItem("en5",  "Burn Energy (250ml)",            "بيرن طاقة (250مل)",             "Carb",  112, 0f,   27f,  0f, sugar=26f),
        FoodItem("en6",  "Power Horse (250ml)",            "باور هورس (250مل)",             "Carb",  112, 0.5f, 26f,  0f, sugar=24f),
        FoodItem("en7",  "Gatorade Blue (500ml)",          "جاتورادي أزرق (500مل)",        "Carb",  130, 0f,   35f,  0f, sugar=34f),
        FoodItem("en8",  "Pocari Sweat (500ml)",           "بوكاري سويت (500مل)",           "Carb",  130, 0f,   32f,  0f, sugar=27f),

        // ═══════════════════════════════════════════════════════════
        // 🍪 BISCUITS & COOKIES (بسكويت وكوكيز)
        // ═══════════════════════════════════════════════════════════
        FoodItem("bi1",  "Oreo Original (3 cookies 34g)", "أوريو أصلي (3 كوكيز 34ج)",     "Snack", 160, 1.5f, 25f,  7f,   sugar=14f),
        FoodItem("bi2",  "Petit Beurre (5 pieces 35g)",   "بتي بور (5 قطع 35ج)",           "Snack", 147, 2.5f, 25f,  4.5f, sugar=8f),
        FoodItem("bi3",  "Digestive (McVitie's 2 pcs)",   "ديجستيف ماكفيتيز (2 قطع)",     "Snack", 141, 2f,   21f,  5.9f, fiber=1.9f),
        FoodItem("bi4",  "Club Biscuit (25g)",             "كلوب بسكويت (25ج)",             "Snack", 127, 1.5f, 17f,  6f,   sugar=10f),
        FoodItem("bi5",  "Molto Original Cake (35g)",      "مولتو أصلي (35ج)",              "Snack", 153, 1.8f, 22f,  7f,   sugar=11f),
        FoodItem("bi6",  "Rio Biscuit (25g)",               "ريو بسكويت (25ج)",             "Snack", 126, 1.3f, 18f,  5.8f, sugar=9f),
        FoodItem("bi7",  "Bisco Misr Plain (30g)",         "بسكويت بسكو مصر سادة (30ج)",   "Snack", 136, 2.5f, 22f,  4.5f),
        FoodItem("bi8",  "Hob Hob (35g)",                  "هوب هوب (35ج)",                 "Snack", 180, 2f,   24f,  8.5f, sugar=13f),

        // ═══════════════════════════════════════════════════════════
        // 🫙 SPREADS & CONDIMENTS (فطار ومربى وزبدة)
        // ═══════════════════════════════════════════════════════════
        FoodItem("sp1",  "Puck Cream Cheese (17g / 1 tbsp)", "جبنة كريم باك (17ج)",       "Dairy",  56, 2f,   1.2f, 5f,   calcium=50f),
        FoodItem("sp2",  "La Vache Qui Rit Triangle (18g)",   "جبنة الضاحكة مثلثة (18ج)", "Dairy",  54, 2.6f, 1.5f, 4.3f, calcium=100f),
        FoodItem("sp3",  "Peanut Butter (1 tbsp 16g)",       "زبدة فول سوداني (معلقة كبيرة)", "Fat", 94, 4f,   3.1f, 8f,  fiber=0.9f),
        FoodItem("sp4",  "Almond Butter (1 tbsp 16g)",       "زبدة لوز (معلقة كبيرة)",    "Fat",    98, 3.4f, 2.9f, 8.9f, calcium=55f),
        FoodItem("sp5",  "Fig Jam 1 tbsp (20g)",             "مربى تين (معلقة كبيرة 20ج)", "Carb",  46, 0.1f, 12f,  0f,  sugar=11f),
        FoodItem("sp6",  "Apricot Jam 1 tbsp (20g)",         "مربى مشمش (معلقة 20ج)",      "Carb",  49, 0.1f, 13f,  0f,  sugar=12f),
        FoodItem("sp7",  "Tahini 1 tbsp (15g)",              "طحينة (معلقة كبيرة 15ج)",    "Fat",   89, 2.6f, 3.2f, 8.1f, calcium=64f),
        FoodItem("sp8",  "Honey 1 tbsp (21g)",               "عسل (معلقة كبيرة 21ج)",      "Carb",  64, 0.1f, 17.3f,0f,  sugar=17f),

        // ═══════════════════════════════════════════════════════════
        // 🥤 FLAVOURED MILK & DRINKS (لبن بالنكهات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("fm1",  "Juhayna Strawberry Milk (200ml)", "جهينة لبن فراولة (200مل)",    "Dairy", 140, 5.5f, 22f,  3.5f, sugar=18f, calcium=200f),
        FoodItem("fm2",  "Juhayna Chocolate Milk (200ml)",  "جهينة لبن شيكولاتة (200مل)",  "Dairy", 148, 5.8f, 23f,  3.8f, sugar=19f, calcium=200f),
        FoodItem("fm3",  "Lamar Flavored Yogurt (100g)",    "لامار زبادي بالفاكهة (100ج)", "Dairy",  95, 3.8f, 14f,  2.8f, sugar=13f),
        FoodItem("fm4",  "Milk Shake (Vanilla, homemade)",  "ميلك شيك فانيليا بيتي",       "Dairy", 170, 6f,   25f,  5.5f, sugar=22f),
        FoodItem("fm5",  "Ayran / Salty Yogurt Drink",      "عيران لبن مالح (250مل)",       "Dairy",  55, 3f,   4.5f, 1.5f, calcium=120f),

        // ═══════════════════════════════════════════════════════════
        // 🍕 FAST FOOD & TAKEAWAY (وجبات سريعة)
        // ═══════════════════════════════════════════════════════════
        FoodItem("ff1",  "KFC Chicken Piece (avg breast)", "قطعة دجاج KFC (صدر متوسط)",   "Protein", 290, 27f, 10f,  16f),
        FoodItem("ff2",  "McDonald's Big Mac",              "ماكدونالدز بيج ماك",           "Mixed",  563, 26f, 44f,  32f),
        FoodItem("ff3",  "McDonald's Chicken Fillet",       "ماكدونالدز تشيكن فيليه",       "Mixed",  390, 22f, 39f,  16f),
        FoodItem("ff4",  "McDonald's French Fries Medium",  "ماكدونالدز فرايز وسط",         "Carb",   320,  4f, 43f,  15f),
        FoodItem("ff5",  "Pizza Slice (cheese, medium)",    "شريحة بيتزا جبنة (متوسطة)",   "Mixed",  285,  12f, 36f, 10f),
        FoodItem("ff6",  "Chicken Burger (local / Hardee)", "برجر دجاج هارديز أو محلي",    "Mixed",  430,  24f, 40f, 18f),
        FoodItem("ff7",  "Koshary Large Bowl",               "كشري طبق كبير",               "Carb",   430,  15f, 82f,  5f, fiber=7f),
        FoodItem("ff8",  "Fiteer Piece (plain, small)",      "فطيرة سادة صغيرة",            "Carb",   260,  5f,  38f, 10f),

        // ═══════════════════════════════════════════════════════════
        // 🥫 CANNED & PACKAGED GOODS (أكل معلّب ومعبّأ)
        // ═══════════════════════════════════════════════════════════
        FoodItem("cn1",  "Canned Foul Medames (400g tin)", "فول مدمس معلّب (علبة 400ج)",   "Protein", 88, 6.5f, 14f, 1f,  fiber=5f),
        FoodItem("cn2",  "Canned Chickpeas (400g tin)",    "حمص معلّب (علبة 400ج)",         "Protein", 120, 7f,  20f, 2f,  fiber=6f),
        FoodItem("cn3",  "Canned Kidney Beans (400g tin)", "فاصوليا حمراء معلّبة (400ج)",  "Protein", 100, 7f,  17f, 0.5f, fiber=5.5f),
        FoodItem("cn4",  "Canned Corn (200g drained)",     "ذرة معلّبة (200ج مصفّاة)",      "Carb",    80, 2.5f, 17f, 0.8f, fiber=1.5f),
        FoodItem("cn5",  "Canned Mushroom (200g)",          "مشروم معلّب (200ج)",            "Veg",     25, 2.5f, 4f,  0.1f),
        FoodItem("cn6",  "Tomato Sauce Carton (100ml)",     "صلصة طماطم (100مل)",            "Veg",     35, 1.5f, 7.5f, 0.3f),
        FoodItem("cn7",  "Pasta Sauce (Panzani 100g)",      "صلصة مكرونة (100ج)",            "Carb",    65, 2f,   11f, 1.5f),

        // ═══════════════════════════════════════════════════════════
        // 🍦 ICE CREAM & FROZEN (آيس كريم)
        // ═══════════════════════════════════════════════════════════
        FoodItem("ic1",  "Cornetto Classic (120ml)",        "كورنيتو كلاسيك (120مل)",       "Snack", 240, 3.5f, 30f, 12f, sugar=22f),
        FoodItem("ic2",  "Magnum Almond (86ml)",            "ماغنوم لوز (86مل)",             "Snack", 290, 3.5f, 27f, 18f, sugar=22f),
        FoodItem("ic3",  "Eskimo Bar (70ml)",                "إسكيمو (70مل)",                "Snack", 175, 2.5f, 20f, 10f, sugar=15f),
        FoodItem("ic4",  "Nesquik Chocolate Ice Cream Bar", "نسكويك آيس بار",               "Snack", 148, 2.5f, 19f,  7f, sugar=16f),

        // ═══════════════════════════════════════════════════════════
        // 🥗 SALADS & MEZZE (سلطات ومقبلات)
        // ═══════════════════════════════════════════════════════════
        FoodItem("sa1",  "Fattoush Salad (no dressing)",    "سلطة فتوش بدون تتبيلة",       "Veg",    65, 2f,   13f,  1f,  fiber=2.5f),
        FoodItem("sa2",  "Tabbouleh (100g)",                "تبولة (100ج)",                 "Veg",    82, 2.5f, 10f,  4f,  fiber=3f),
        FoodItem("sa3",  "Greek Salad (100g)",              "سلطة يونانية (100ج)",          "Veg",    95, 2.5f,  5f,   7.5f, fiber=1.5f),
        FoodItem("sa4",  "Caesar Salad (no croutons 100g)", "سيزر سلطة بدون خبز (100ج)",   "Veg",    90, 4f,    3f,   7f),
        FoodItem("sa5",  "Egyptian Green Salad",            "سلطة خضراء مصرية",             "Veg",    25, 1.5f,  4.5f, 0.5f, fiber=2f),

        // ═══════════════════════════════════════════════════════════
        // 🍳 BREAKFAST COMBINATIONS (وجبات إفطار)
        // ═══════════════════════════════════════════════════════════
        FoodItem("bk1",  "Full Egyptian Breakfast",         "إفطار مصري كامل",              "Mixed", 520, 22f,  62f, 20f,  fiber=8f),
        FoodItem("bk2",  "Oats with Banana & Honey",        "شوفان بالموز والعسل",          "Carb",  340, 10f,  62f,  5f,  fiber=6f),
        FoodItem("bk3",  "Toast with Egg & Cheese",         "توست ببيضة وجبنة",             "Mixed", 320, 18f,  28f, 14f),
        FoodItem("bk4",  "Greek Yogurt with Fruits",        "زبادي يوناني بالفاكهة",        "Protein",195, 14f,  24f,  4f),
        FoodItem("bk5",  "Protein Pancakes (2 pcs)",        "بان كيك بروتين (2 قطعة)",      "Mixed", 280, 22f,  28f,  7f, fiber=3f),

        // ═══════════════════════════════════════════════════════════
        // 🛒 CARREFOUR EGYPT — منتجات موجودة فعلاً
        // ═══════════════════════════════════════════════════════════

        // ── أرز وحبوب ──────────────────────────────────────────────
        FoodItem("rice1", "Uncle Ben's Long Grain (100g raw)","أنكل بنز أرز بسمتي (100ج خام)", "Carb", 360, 7f,  79f, 0.5f, fiber=1f),
        FoodItem("rice2", "Egyptian White Rice Badr (100g)", "أرز بدر مصري أبيض (100ج خام)",  "Carb", 352, 7f,  78f, 0.6f),
        FoodItem("rice3", "Dreamfields Brown Rice (100g)",   "أرز بني درمفيلدز (100ج خام)",   "Carb", 362, 7.5f,76f, 2.8f, fiber=3.5f),
        FoodItem("rice4", "Egyptian Rice Cooked (100g)",     "أرز مصري مطبوخ (100ج)",          "Carb", 130, 2.5f,28f, 0.3f),
        FoodItem("rice5", "Basmati Rice Cooked (100g)",      "أرز بسمتي مطبوخ (100ج)",         "Carb", 121, 3.5f,26f, 0.4f),

        // ── مكرونة وشعيرية ─────────────────────────────────────────
        FoodItem("mac1", "Barilla Spaghetti No.5 (100g raw)","باريلا سباغيتي 5 (100ج خام)",   "Carb", 357, 12f, 71f, 1.5f, fiber=2.5f),
        FoodItem("mac2", "Panzani Penne (100g raw)",          "بانزاني بيني (100ج خام)",        "Carb", 354, 11f, 72f, 1.3f, fiber=2f),
        FoodItem("mac3", "Da Vinci Pasta (100g raw)",         "دا فينشي مكرونة (100ج خام)",    "Carb", 353, 11f, 72f, 1.4f),
        FoodItem("mac4", "Egyptian Macaroni (Bolognese cut)", "مكرونة مصري قطعة بولونيز (100ج)","Carb", 352, 11f, 73f, 1.2f),
        FoodItem("mac5", "Noodles (Indomie dry 85g)",         "نودلز إندومي جاف (85ج)",         "Carb", 380, 8f,  52f, 16f),
        FoodItem("mac6", "Knorr Noodles Chicken (70g)",       "نودلز كنور دجاج (70ج)",          "Carb", 316, 7f,  46f, 12f),

        // ── دقيق وزيوت ─────────────────────────────────────────────
        FoodItem("fl1", "All Purpose Flour (100g)",           "دقيق أبيض عادي (100ج)",          "Carb", 364, 10f, 76f, 1f,  fiber=2.7f),
        FoodItem("fl2", "Whole Wheat Flour (100g)",           "دقيق قمح كامل (100ج)",            "Carb", 340, 13f, 72f, 2.5f, fiber=10.7f),
        FoodItem("fl3", "Corn Starch (100g)",                 "نشا ذرة (100ج)",                  "Carb", 381, 0.3f,91f, 0.1f),
        FoodItem("fl4", "Vegetable Oil Afia 1 tbsp (14g)",   "زيت عافية نباتي (معلقة 14ج)",    "Fat",  124, 0f,  0f,  14f),
        FoodItem("fl5", "Sunflower Oil Helwa (1 tbsp 14g)",  "زيت حلوة عباد شمس (معلقة 14ج)", "Fat",  124, 0f,  0f,  14f),

        // ── ألبان ومشتقات (كارفور) ──────────────────────────────────
        FoodItem("kd1", "Nestle Nesquik Milk Chocolate 200ml","نستله نسكويك شيكولاتة (200مل)", "Dairy", 152, 6f,  24f, 3.8f, sugar=22f, calcium=240f),
        FoodItem("kd2", "Arla Protein Yogurt (150g)",         "أرلا زبادي بروتين (150ج)",       "Protein", 96, 12f, 9f, 1.5f, calcium=220f),
        FoodItem("kd3", "Activia Fiber Yogurt (120g)",        "أكتيفيا زبادي فايبر (120ج)",     "Dairy",  95, 4f,  13f, 2.5f, fiber=1.5f),
        FoodItem("kd4", "Puck Full Fat Cheese Spread (140g)","جبنة باك دسمة (140ج)",            "Dairy", 280, 9.5f,5f, 25f, calcium=200f),
        FoodItem("kd5", "President Butter Unsalted (100g)",  "زبدة بريزيدينت بدون ملح (100ج)", "Fat",  717, 0.5f,0.6f,81f, calcium=20f),
        FoodItem("kd6", "Philadelphia Cream Cheese (100g)",  "فيلادلفيا كريم تشيز (100ج)",    "Dairy", 253, 5f,  4f,  25f, calcium=100f),
        FoodItem("kd7", "Danette Caramel Pudding (100g)",    "دانيت كراميل (100ج)",             "Snack", 123, 3f,  18f,  4.5f, sugar=16f),
        FoodItem("kd8", "Nestlé Condensed Milk (40g/2tbsp)", "نستله حليب مركز (40ج)",           "Dairy", 130, 3.2f,22f, 3.5f, sugar=22f),
        FoodItem("kd9", "Sour Cream (100g)",                  "قشطة حامض (100ج)",               "Dairy", 193, 2f,  4.6f,19f),
        FoodItem("kd10","Whipping Cream (100ml)",              "كريمة الخفق (100مل)",            "Fat",  337, 2f,  3f,  35f, sugar=3f),

        // ── عصائر وصودا (كارفور) ────────────────────────────────────
        FoodItem("jx1", "Capri Sun Orange (200ml pouch)",    "كابري سن برتقال (200مل)",        "Carb",  90, 0f,  22f,  0f, sugar=21f),
        FoodItem("jx2", "Nestle Pure Life Water (500ml)",    "نستله بيور لايف ماء (500مل)",   "Carb",   0, 0f,  0f,   0f),
        FoodItem("jx3", "Baraka Water (600ml)",               "باراكا ماء (600مل)",             "Carb",   0, 0f,  0f,   0f),
        FoodItem("jx4", "Siwa Water (600ml)",                  "سيوة ماء (600مل)",              "Carb",   0, 0f,  0f,   0f),
        FoodItem("jx5", "Tang Orange Powder (1 sachet 9g)",  "تانج برتقال (ساشيه 9ج)",         "Carb",  34, 0f,  8.5f, 0f, sugar=8f),
        FoodItem("jx6", "Coca-Cola Zero 330ml",               "كوكاكولا زيرو (330مل)",          "Carb",   1, 0f,  0.1f, 0f),
        FoodItem("jx7", "Fanta Orange 330ml",                  "فانتا برتقال (330مل)",           "Carb", 148, 0f,  37f,  0f, sugar=37f),
        FoodItem("jx8", "Schweppes Lemon (330ml)",             "شويبس ليمون (330مل)",            "Carb",  63, 0f,  16f,  0f, sugar=15f),
        FoodItem("jx9", "Evian Water (500ml)",                 "إيفيان ماء (500مل)",             "Carb",   0, 0f,  0f,   0f),
        FoodItem("jx10","Rani Float Orange (240ml)",           "راني فلوت برتقال (240مل)",       "Carb", 120, 0f,  30f,  0f, sugar=28f),
        FoodItem("jx11","Juhayna Guava Juice 1L",              "جهينة عصير جوافة (1 لتر)",       "Carb",  58, 0.3f,14f, 0f, sugar=13f),
        FoodItem("jx12","Cappy Orange Juice (240ml)",          "كابي برتقال (240مل)",            "Carb",  96, 0.5f,23f, 0.2f, sugar=20f),

        // ── شيبسي وسناكس (كارفور) ───────────────────────────────────
        FoodItem("sx1", "Pringles Cheezums (40g)",             "برينجلز جبنة (40ج)",             "Snack", 548, 6f,  52f,  36f),
        FoodItem("sx2", "Cheetos Crunchy (30g)",               "شيتوز كرانشي (30ج)",             "Snack", 450, 6f,  56f,  22f),
        FoodItem("sx3", "Frito Corn Chips (30g)",              "فريتو شيبس (30ج)",               "Snack", 480, 7f,  48f,  28f),
        FoodItem("sx4", "Popcorn (Orolé Cheese 30g)",          "فشار أوروليه جبنة (30ج)",        "Snack", 390, 8f,  60f,  15f),
        FoodItem("sx5", "Bugles Nacho (30g)",                   "بيوجلز ناتشو (30ج)",            "Snack", 470, 6f,  60f,  24f),
        FoodItem("sx6", "Chipsy Flips (30g)",                   "شيبسي فليبس (30ج)",             "Snack", 440, 8f,  68f,  14f),
        FoodItem("sx7", "Mister Corn (30g)",                    "مستر كورن (30ج)",               "Snack", 398, 7f,  65f,  13f),
        FoodItem("sx8", "Bake Rolz Original (40g)",             "بيك رولز أصلي (40ج)",           "Snack", 412, 11f, 70f,  10f),
        FoodItem("sx9", "Lay's Wavy (30g)",                     "ليز ويفي (30ج)",                "Snack", 538, 6f,  52f,  35f),
        FoodItem("sx10","Ruffles Cheddar (30g)",                "رافلز شيدر (30ج)",              "Snack", 525, 6.5f,53f, 33f),

        // ── توست وخبز مصنّع ──────────────────────────────────────────
        FoodItem("tb1", "Bisco Misr Sandwich Bread (25g sl)","بسكو مصر خبز توست (شريحة 25ج)", "Carb",  66, 2f,  13f,  0.8f),
        FoodItem("tb2", "Harry's Toast White (35g slice)",   "هاريز توست أبيض (شريحة 35ج)",   "Carb",  95, 3f,  17f,  1.5f),
        FoodItem("tb3", "Semsema Bread (100g)",               "عيش سمسم (100ج)",               "Carb", 285, 9f,  53f,  4f,  fiber=3.5f),
        FoodItem("tb4", "Tortilla Wrap (30g piece)",          "تورتيلا رابت (30ج)",             "Carb",  90, 2.4f,15f,  2f),
        FoodItem("tb5", "Cracker Crackers Plain (25g)",       "كراكرز سادة (25ج)",              "Carb", 108, 2.5f,17f,  4f),

        // ── مكملات غذائية موجودة في كارفور ─────────────────────────
        FoodItem("sup1","ON Gold Standard Whey 1 scoop 30g","أوبتيمم واي بروتين (30ج)",       "Protein",120,24f, 3f,  1.5f),
        FoodItem("sup2","MuscleTech Nitro-Tech 1 scoop 42g","نيترو تك ماسل تك (42ج)",          "Protein",160,30f, 5f,  2.5f),
        FoodItem("sup3","BSN Syntha-6 1 scoop 47g",          "بي إس إن سينثا 6 (47ج)",         "Protein",200,22f, 15f, 6f),
        FoodItem("sup4","Quest Bar Chocolate Chip (60g)",    "كويست بار شيكولاتة (60ج)",       "Protein",200,21f, 25f, 7f,  fiber=14f, sugar=1f),
        FoodItem("sup5","Clif Bar Energy Bar (68g)",          "كليف بار (68ج)",                 "Mixed", 250, 9f,  45f, 5f,  fiber=5f, sugar=21f),
        FoodItem("sup6","Creatine Monohydrate 5g serving",   "كرياتين مونوهيدرات (5ج)",        "Supplement",0,0f,  0f,  0f),
        FoodItem("sup7","BCAA (5g serving)",                  "BCAA (5ج)",                      "Supplement",20,5f,  0f, 0f),

        // ── خضار مجمّد وسريع ──────────────────────────────────────
        FoodItem("fv1", "Frozen Peas (100g cooked)",          "بسلة مجمّدة مطبوخة (100ج)",     "Veg",   77, 5f,  14f,  0.4f, fiber=4.5f),
        FoodItem("fv2", "Frozen Mixed Veg (100g cooked)",     "خضار متنوعة مجمّدة (100ج)",     "Veg",   65, 3f,  12f,  0.5f, fiber=3f),
        FoodItem("fv3", "Frozen Corn (100g cooked)",           "ذرة مجمّدة (100ج)",             "Carb",  86, 3.3f,19f, 1.2f, fiber=2.4f),
        FoodItem("fv4", "Frozen Broccoli (100g cooked)",      "بروكلي مجمّد (100ج)",            "Veg",   28, 3f,  5f,   0.3f, fiber=2.6f),

        // ── صلصات وتوابل (كارفور) ────────────────────────────────────
        FoodItem("sc1", "Heinz Ketchup (1 tbsp 17g)",         "هاينز كاتشب (معلقة 17ج)",       "Carb",  20, 0.3f,4.5f, 0.1f, sugar=4f),
        FoodItem("sc2", "Heinz Mayonnaise (1 tbsp 15g)",      "هاينز مايونيز (معلقة 15ج)",     "Fat",  104, 0.2f,0.8f, 11f),
        FoodItem("sc3", "Knorr Chicken Stock Cube (1 cube)",  "كنور مكعب دجاج (مكعبة واحدة)",  "Carb",  20, 1f,  2.5f, 0.8f),
        FoodItem("sc4", "Maggi Seasoning Sauce (1 tsp 5ml)", "ماجي صوص تتبيل (معلقة 5مل)",    "Carb",   4, 0.5f,0.6f, 0.1f),
        FoodItem("sc5", "Tabasco Hot Sauce (1 tsp 5ml)",     "تاباسكو صوص حار (5مل)",          "Carb",   1, 0f,  0.1f, 0f),
        FoodItem("sc6", "Soy Sauce Kikkoman (1 tbsp 15ml)",  "صوص صويا كيكومان (15مل)",        "Carb",  11, 1.3f,1f,   0.1f),
        FoodItem("sc7", "Worcestershire Sauce (1 tsp 5ml)",  "وورسيسترشاير صوص (5مل)",         "Carb",  12, 0.1f,3f,   0f),
        FoodItem("sc8", "Harissa Paste (1 tbsp 15g)",         "هريسة (معلقة 15ج)",              "Veg",   25, 1f,  4f,   0.8f),

        // ── بهارات وتوابل (كارفور) ───────────────────────────────────
        FoodItem("sp10","Ground Cumin (1 tsp 2g)",            "كمون مطحون (معلقة صغيرة 2ج)",   "Carb",   8, 0.4f,1f,   0.4f),
        FoodItem("sp11","Ground Cinnamon (1 tsp 2g)",         "قرفة مطحونة (معلقة صغيرة 2ج)", "Carb",   5, 0.1f,1.5f, 0.1f),
        FoodItem("sp12","Black Pepper (1 tsp 2g)",             "فلفل أسود (معلقة صغيرة 2ج)",    "Carb",   6, 0.2f,1.5f, 0.1f),
        FoodItem("sp13","Turmeric (1 tsp 2g)",                 "كركم (معلقة صغيرة 2ج)",         "Carb",   7, 0.2f,1.4f, 0.2f),
        FoodItem("sp14","Dry Oregano (1 tsp 1g)",              "أوريجانو جاف (معلقة 1ج)",        "Carb",   3, 0.1f,0.7f, 0.1f),

        // ── حلويات مصرية شهيرة ───────────────────────────────────────
        FoodItem("eg22","Baklava (1 piece 30g)",               "بقلاوة (قطعة 30ج)",             "Snack", 160, 2.5f,19f,  9f,  sugar=14f),
        FoodItem("eg23","Umm Ali with Cream (150g serving)",   "أم علي بالقشطة (150ج)",         "Mixed", 410, 8f,  48f,  21f, sugar=28f),
        FoodItem("eg24","Basbousa (1 piece 50g)",               "بسبوسة (قطعة 50ج)",             "Snack", 200, 3f,  34f,  6.5f, sugar=22f),
        FoodItem("eg25","Halawet El Gebn (100g)",               "حلاوة الجبن (100ج)",            "Snack", 310, 8f,  42f,  13f, sugar=30f),
        FoodItem("eg26","Qatayef Filled (1 piece 60g)",         "قطايف محشوة (60ج)",             "Snack", 195, 4f,  28f,  8f,  sugar=14f),
        FoodItem("eg27","Ghorayeba (1 biscuit 20g)",            "غريبة (قطعة 20ج)",              "Snack", 100, 1.5f,12f,  5.5f, sugar=8f),
        FoodItem("eg28","Sobia Drink (250ml)",                  "سوبيا (250مل)",                 "Carb",  120, 1f,  28f,  1f,  sugar=25f),
        FoodItem("eg29","Tamr Hindi Drink (250ml)",             "تمر هندي (250مل)",              "Carb",   80, 0.5f,20f, 0f,  sugar=18f),
        FoodItem("eg30","Karkade (Hibiscus Tea 250ml no sugar)","كركديه بدون سكر (250مل)",       "Carb",   15, 0.2f,3.5f, 0f),

        // ── سمك بكل أنواعه (كارفور فريش) ─────────────────────────────
        FoodItem("sf1", "Red Snapper (Sagr) Grilled 100g",    "سمك سقر مشوي (100ج)",           "Protein",128, 26f, 0f,  2.5f),
        FoodItem("sf2", "Sea Bream (Dorade) Grilled 100g",    "دنيس مشوي (100ج)",              "Protein",121, 25f, 0f,  2.2f),
        FoodItem("sf3", "Hamour (Grouper) Grilled 100g",      "هامور مشوي (100ج)",             "Protein",119, 24f, 0f,  2.5f),
        FoodItem("sf4", "Calamari Fried (100g)",               "كالاماري مقلي (100ج)",          "Protein",175, 15f, 8f,  9f),
        FoodItem("sf5", "Shrimp Grilled (100g)",               "جمبري مشوي (100ج)",             "Protein", 84, 20f, 0f,  0.3f),
        FoodItem("sf6", "Fish Fingers Frozen (4 pcs 100g)",   "أصابع سمك مجمّدة (4 قطع)",     "Protein",200, 12f, 17f, 9f),

        // ── لحوم مصنّعة (كارفور) ─────────────────────────────────────
        FoodItem("pm1", "Americana Beef Burger (100g raw)",   "برجر لحم أمريكانا (100ج نيء)",  "Protein",267, 19f, 3f,  20f),
        FoodItem("pm2", "Americana Chicken Nuggets (100g)",   "ناجتس دجاج أمريكانا (100ج)",    "Protein",238, 15f, 16f, 12f),
        FoodItem("pm3", "Americana Grilled Chicken Strip 100g","شرائح دجاج أمريكانا مشوية",    "Protein",165, 28f, 3f,   5f),
        FoodItem("pm4", "Smoked Beef Hot Dog (50g)",           "نقانق بقري مدخن (50ج)",         "Protein",152, 7f,  3f,  13f),
        FoodItem("pm5", "Chicken Cordon Bleu (150g piece)",   "كوردون بلو دجاج (قطعة 150ج)",   "Mixed",  340, 24f, 18f, 18f),

        // ── حبوب ومكسرات (بالوزن) ────────────────────────────────────
        FoodItem("nb1", "Mixed Nuts Roasted (30g serving)",   "مكسرات متنوعة محمصة (30ج)",     "Fat",   177, 5f,  7f,  16f, fiber=2f),
        FoodItem("nb2", "Trail Mix with Raisins (30g)",        "ميكس مكسرات وزبيب (30ج)",       "Mixed", 130, 3f,  16f, 7f,  fiber=1.5f, sugar=9f),
        FoodItem("nb3", "Roasted Sunflower Seeds (30g)",       "بذور دوار شمس محمصة (30ج)",     "Fat",   175, 6f,  6f,  15f, fiber=2.6f),
        FoodItem("nb4", "Dried Raisins (30g)",                  "زبيب مجفف (30ج)",               "Carb",   90, 1f,  23f, 0.1f, sugar=18f),
        FoodItem("nb5", "Dried Apricots (30g)",                 "مشمش مجفف (30ج)",               "Carb",   78, 1f,  20f, 0.1f, sugar=15f, iron=0.7f),
        FoodItem("nb6", "Dried Cranberries (30g)",              "كرانبيري مجفف (30ج)",            "Carb",   93, 0.1f,25f, 0.1f, sugar=20f),

        // ── عصير طبيعي (بيتي وعصّار) ─────────────────────────────────
        FoodItem("fj1", "Fresh Orange Juice (200ml)",          "عصير برتقال طبيعي (200مل)",     "Carb",   86, 1.3f,20f, 0.4f, sugar=17f),
        FoodItem("fj2", "Fresh Mango Juice (200ml)",           "عصير مانجو طبيعي (200مل)",      "Carb",  116, 1.4f,28f, 0.5f, sugar=26f),
        FoodItem("fj3", "Fresh Guava Juice (200ml)",            "عصير جوافة طبيعي (200مل)",     "Carb",  106, 1.6f,26f, 0.5f, sugar=22f),
        FoodItem("fj4", "Fresh Sugarcane Juice (200ml)",        "عصير قصب (200مل)",              "Carb",  180, 0.5f,46f, 0.2f, sugar=44f),
        FoodItem("fj5", "Pomegranate Juice Fresh (200ml)",     "عصير رمان طبيعي (200مل)",       "Carb",  148, 1.5f,37f, 0.7f, sugar=31f),
        FoodItem("fj6", "Lemon with Mint (200ml no sugar)",    "ليمون بالنعناع بدون سكر",       "Carb",   18, 0.5f,5.5f, 0.1f),
        FoodItem("fj7", "Carrot Juice Fresh (200ml)",           "عصير جزر طبيعي (200مل)",       "Carb",   76, 1.6f,18f, 0.3f),

        // ── إفطار سريع وحلويات سريعة ──────────────────────────────────
        FoodItem("qs1", "Waffle (1 piece 75g)",                 "وافل (قطعة 75ج)",               "Carb",  235, 6f,  35f, 8f,  sugar=12f),
        FoodItem("qs2", "French Crepe Plain (1 piece 50g)",     "كريب فرنسي سادة (50ج)",         "Carb",  112, 3f,  14f, 5f),
        FoodItem("qs3", "Donut Glazed (1 piece 60g)",           "دونت مزجّج (60ج)",              "Snack", 245, 3f,  34f, 12f, sugar=16f),
        FoodItem("qs4", "Croissant Plain (60g)",                 "كرواسون سادة (60ج)",            "Carb",  240, 5f,  27f, 13f),
        FoodItem("qs5", "Muffin Chocolate (100g)",               "مافن شيكولاتة (100ج)",          "Snack", 435, 6f,  57f, 22f, sugar=32f)
    )
}
