package com.masb1ue.holidemo2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData

@Composable
fun ProductScreen(
    modifier: Modifier,
    product: Product
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = product.name,
            fontSize = 24.sp,
            color = colorResource(id = R.color.text_color)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = rememberAsyncImagePainter(product.image[0]),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Image(
                painter = painterResource(id = SampleData.demoList[0]),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = SampleData.demoList[1]),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(id = SampleData.demoList[2]),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f),
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${product.name}介紹",
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_color)
        )
        Text(
            text = product.detail,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color_light)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "單一尺寸：",
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_color)
        )
        Text(
            text = product.size,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color_light)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "款式種類：",
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_color)
        )
        Text(
            text = "牛皮紙 / 白銅紙 / 黑卡紙",
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color_light)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "備註：數量300以上以需客製化歡迎來訊",
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color)
        )
        Text(
            text = "誤差：±2mm為正常誤差值",
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color)
        )
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreen(
        Modifier, Product(
            id = 3,
            subtitle = "BABA 美式輕食",
            name = "環保純白包裝袋",
            detail = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
            cost = 23,
            size = "large",
            remark = "remark",
            category1 = "食品",
            category2 = "商品售賣",
            image = listOf("https://api.waproject-gift.store/api/v1/static/3_1681371997.png")
        )
    )
}