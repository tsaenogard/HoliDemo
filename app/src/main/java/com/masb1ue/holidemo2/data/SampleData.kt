package com.masb1ue.holidemo2.data

import com.masb1ue.holidemo2.R
import com.masb1ue.holidemo2.api.CategoryResponse
import com.masb1ue.holidemo2.api.ImageData


object SampleData {
    //    val bottomNavItems = listOf(
//        BottomNavItem(
//            name = "首頁",
//            route = "home",
//            icon = R.drawable.icon_gift,
//        ),
//        BottomNavItem(
//            name = "聯絡",
//            route = "contact",
//            icon = R.drawable.icon_support,
//        ),
//        BottomNavItem(
//            name = "我的",
//            route = "settings",
//            icon = R.drawable.icon_user,
//        ),
//    )
//    val categoryList = listOf(
//        CategoryItem("食品", R.drawable.food),
//        CategoryItem("酒類", R.drawable.wine),
//        CategoryItem("金融", R.drawable.finance),
//        CategoryItem("飯店", R.drawable.hotel),
//        CategoryItem("精品", R.drawable.luxury),
//        CategoryItem("其他", R.drawable.luxury),
//    )
    val tabs = listOf("餅乾", "蛋糕", "喜餅", "零食", "特殊")
    val bannerList = listOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3
    )
    val demoList = listOf(
        R.drawable.take_out_box02,
        R.drawable.take_out_box03,
        R.drawable.take_out_box04
    )
    val naviList = listOf(
        "首頁", "聯絡", "我的"
    )
    val naviIconList = listOf(
        R.drawable.icon_gift, R.drawable.icon_support, R.drawable.icon_user
    )
    val naviRouteList = listOf(
        "home", "contact", "my"
    )
    val usageList = listOf(
        "節慶活動", "紀念贈禮", "商品售賣", "三節禮盒"
    )
    val usageTitleList = listOf(
        "全部", "節慶活動", "紀念贈禮", "商品售賣", "三節禮盒"
    )
    val industryList = listOf(
        "全部", "食品製造", "酒類", "餐飲", "旅館飯店", "時尚精品"
    )
    val industryTitleList = listOf(
        "全部", "食品製造", "酒類", "餐飲", "旅館飯店", "時尚精品"
    )
    val categoryImgList = listOf(
        R.drawable.all,
        R.drawable.food,
        R.drawable.wine,
        R.drawable.finance,
        R.drawable.hotel,
        R.drawable.luxury,
        R.drawable.luxury
    )
    val homeProductList = listOf(
        Product(
            id = 4,
            priority = 1,
            subtitle = "BASR 沁涼口香糖",
            name = "時尚封口袋",
            content = "優質材料製作，質感和耐用兼具，能有效保護內部物品不受潮濕、灰塵影響",
            cost = "袋裝設計(單位/款)<br>3,000-5,000元",
            size = "長 x 寬 x 高(公釐mm)<br>100 x 15 x 140",
            style = "3 種款式材料<br>白棉紙 / PP / PE",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(1, "商品售賣"),
                CategoryResponse(0, "食品製造")
            ),
            imageData = listOf(
                ImageData(
                    4,
                    "https://api.waproject-gift.store/api/v1/static/4_1683390994.png"
                )
            )
        ),
        Product(
            id = 5,
            priority = 1,
            subtitle = "MagicMind 健康蔬食",
            name = "繽紛彩繪包裝盒",
            content = "繽紛設計、環保材料、優質印刷，是一款適合包裝食品並為其增色的時尚選擇",
            cost = "一般盒型設計(單位/款)<br>3,000-10,000元",
            size = "長 x 寬 x 高(公釐mm)<br>250 x 150 x 200",
            style = "3 種款式材料<br>雪銅紙 / 象牙紙 / 白卡紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(0, "餐飲"),
                CategoryResponse(1, "商品售賣"),
            ),
            imageData = listOf(
                ImageData(
                    5,
                    "https://api.waproject-gift.store/api/v1/static/5_1683390994.png"
                )
            )
        ),
        Product(
            id = 2,
            priority = 1,
            subtitle = "Groupserip Afer 美式料理",
            name = "簡約外帶盒",
            content = "適用於包裝各種食品，可作為送禮、餐飲外帶、婚禮、聚會等場合使用",
            cost = "一般盒型設計(單位/款)<br>3,000-10,000元",
            size = "長 x 寬 x 高(公釐mm)<br>300 x 150 x 150",
            style = "2 種款式材料<br>黃牛皮紙 / 白牛皮紙 ",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(0, "餐飲"),
                CategoryResponse(1, "商品售賣"),
            ),
            imageData = listOf(
                ImageData(
                    2,
                    "https://api.waproject-gift.store/api/v1/static/2_1683390992.png"
                )
            )
        ),
        Product(
            id = 8,
            priority = 1,
            subtitle = "mildee 溫柔護",
            name = "簡約抽屜紙盒",
            content = "以三個英文字「i」為主體造形，融入整體設計當中，整體設計簡約卻不失質感的紙盒抽屜禮盒",
            cost = "單面盒型設計(單位/款)<br>5,000-10,000元",
            size = "長 x 寬 x 高(公釐mm)<br>300 x 200 x 100",
            style = "3 種款式材料<br>黃牛皮紙 / 白銅紙 / 黑卡紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(1, "紀念贈禮"),
                CategoryResponse(1, "商品售賣"),
                CategoryResponse(0, "旅館飯店")
            ),
            imageData = listOf(
                ImageData(
                    8,
                    "https://api.waproject-gift.store/api/v1/static/8_1683390997.png"
                )
            )
        ),
        Product(
            id = 7,
            priority = 1,
            subtitle = "Marion Bataille",
            name = "醇藏年華禮盒",
            content = "獨特的設計打造出優雅、精美外觀，包裝印有幾何圖案，使禮盒更具藝術性和紀念價值",
            cost = "特殊盒形設計(單位/款)<br>20,000-50,000元",
            size = "長 x 寬 x 高(公釐mm)<br>400 x 250 x 100",
            style = "2 種款式材料<br>黑卡紙 / 白卡紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(1, "節慶活動"),
                CategoryResponse(1, "紀念贈禮"),
                CategoryResponse(0, "酒類"),
                CategoryResponse(1, "三節禮盒"),
            ),
            imageData = listOf(
                ImageData(
                    7,
                    "https://api.waproject-gift.store/api/v1/static/7_1683390997.png"
                )
            )
        ),
        Product(
            id = 18,
            priority = 1,
            subtitle = "BEYOND",
            name = "印花禮盒",
            content = "Pure Fizz採用了金屬的鋁製瓶子和幾何圖形的外觀，展現了其清爽、無糖、健康的形象。",
            cost = "一般盒型設計(單位/款)<br>3,000-10,000元",
            size = "長 x 寬 x 高(公釐mm)<br>250 x 150 x 200",
            style = "3 種款式材料<br>雪銅紙 / 象牙紙 / 白卡紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(1, "商品售賣"),
                CategoryResponse(0, "食品製造")
            ),
            imageData = listOf(
                ImageData(
                    18,
                    "https://api.waproject-gift.store/api/v1/static/18_1683391006.png"
                )
            )
        ),
        Product(
            id = 3,
            priority = 1,
            subtitle = "BABA 美式輕食",
            name = "手工紙袋",
            content = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
            cost = "袋裝設計(單位/款)<br>3,000-5,000元",
            size = "長 x 寬 x 高(公釐mm)<br>200 x 150 x 250",
            style = "2 種款式材料<br>白牛皮紙／本色牛皮紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(0, "餐飲"),
                CategoryResponse(1, "商品售賣"),
            ),
            imageData = listOf(
                ImageData(
                    3,
                    "https://api.waproject-gift.store/api/v1/static/3_1683390993.png"
                )
            )
        ),
        Product(
            id = 32,
            priority = 1,
            subtitle = "Dr.Yang",
            name = "環保紙袋",
            content = "瓶身的形狀設計為長方形，方便攜帶。標籤上印有「Dr.Yang Crampless Tea」的字樣。以牛皮紙為主要材質，表示產品的天然與健康。",
            cost = "單面盒型設計(單位/款)<br>5,000-10,000元",
            size = "長 x 寬 x 高(公釐mm)<br>100 x 100 x 250",
            style = "1 種款式材料<br>黃牛皮紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(1, "商品售賣"),
                CategoryResponse(0, "食品製造")
            ),
            imageData = listOf(
                ImageData(
                    32,
                    "https://api.waproject-gift.store/api/v1/static/32_1683391019.png"
                )
            )
        ),
        Product(
            id = 3,
            priority = 1,
            subtitle = "BABA 美式輕食",
            name = "印裝紙袋",
            content = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
            cost = "袋裝設計(單位/款)<br>3,000-5,000元",
            size = "長 x 寬 x 高(公釐mm)<br>200 x 150 x 250",
            style = "2 種款式材料<br>白牛皮紙／本色牛皮紙",
            remark = "1.訂購最低數量需300件，客製化歡迎來訊<br> 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。<br>誤差：±2mm為正常誤差值",
            category = listOf(
                CategoryResponse(0, "餐飲"),
                CategoryResponse(1, "商品售賣"),
            ),
            imageData = listOf(
                ImageData(
                    3,
                    "https://api.waproject-gift.store/api/v1/static/3_1683390993.png"
                )
            )
        ),
    )
    val homeProductImageList = listOf(
        R.drawable.case01,
        R.drawable.case02,
        R.drawable.case03,
        R.drawable.case04,
        R.drawable.case05,
        R.drawable.case06,
        R.drawable.case07,
        R.drawable.case08,
        R.drawable.case09,
    )
    val productList = listOf(
        Product(
            id = 0,
            priority = 1,
            subtitle = "美式外帶盒",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf(),
        ),
        Product(
            id = 1,
            priority = 1,
            subtitle = "印花袋裝",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf()
        ),
        Product(
            id = 0,
            priority = 1,
            subtitle = "長型盒裝",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf()
        ),
        Product(
            id = 0,
            priority = 1,
            subtitle = "透明包裝",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf()
        ),
        Product(
            id = 0,
            priority = 1,
            subtitle = "透明包裝",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf()
        ),
        Product(
            id = 0,
            priority = 1,
            subtitle = "透明包裝",
            name = "",
            content = "",
            cost = "",
            size = "",
            style = "",
            remark = "",
            category = listOf(),
            imageData = listOf()
        ),
    )

    val sampleProduct = Product(
        id = 1,
        priority = 1,
        subtitle = "collehouse 大理石精品",
        name = "璀璨之愛禮盒組",
        content = "由高品質的白色大理石紋印製而成，展現出高貴優雅的氛圍，表達真摯感情的完美選擇",
        cost = "單面盒型設計(單位/款)\n5,000-10,000元",
        size = "長 x 寬 x 高(公釐mm)\n150 x 150 x 100",
        style = "3 種款式材料\n白卡紙／雪銅紙／象牙紙",
        remark = "1.訂購最低數量需300件，客製化歡迎來訊\n 2.以上報價僅為參考，費用會依包裝結構、材質、加工及複雜度影響單價，實際價錢以最終報價為主。\n誤差：±2mm為正常誤差值",
        category = listOf(
            CategoryResponse(0, "時尚精品"),
            CategoryResponse(1, "節慶活動"),
            CategoryResponse(1, "紀念贈禮"),
        ),
        imageData = listOf(
            ImageData(
                1,
                "https://api.waproject-gift.store/api/v1/static/1_1683390992.png"
            )
        )
    )
}


