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
        "食品製造", "酒類", "餐飲", "旅館飯店", "時尚精品"
    )
    val industryTitleList = listOf(
        "全部", "食品製造", "酒類", "餐飲", "旅館飯店", "時尚精品"
    )
    val categoryImgList = listOf(
        R.drawable.food,
        R.drawable.wine,
        R.drawable.finance,
        R.drawable.hotel,
        R.drawable.luxury,
        R.drawable.luxury
    )
    val homeProductList = listOf(
        ProductTemp(
            id = 1,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case01
        ),
        ProductTemp(
            id = 2,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case02
        ),
        ProductTemp(
            id = 3,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case03
        ),
        ProductTemp(
            id = 4,
            subtitle = "手工抽屜",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case04
        ),
        ProductTemp(
            id = 5,
            subtitle = "手工紙袋",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case05
        ),
        ProductTemp(
            id = 6,
            subtitle = "印花禮盒",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case06
        ),
        ProductTemp(
            id = 7,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case07
        ),
        ProductTemp(
            id = 8,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case08
        ),
        ProductTemp(
            id = 9,
            subtitle = "形象包裝",
            name = "",
            detail = "",
            cost = 0,
            size = "",
            remark = "",
            category1 = "",
            category2 = "",
            image = R.drawable.case09
        ),
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


