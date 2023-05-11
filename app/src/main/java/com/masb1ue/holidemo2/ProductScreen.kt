package com.masb1ue.holidemo2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.masb1ue.holidemo2.api.Category
import com.masb1ue.holidemo2.api.CategoryResponse
import com.masb1ue.holidemo2.api.ImageData
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
        val topImage = remember{ mutableStateOf(product.imageData[0].url) }
        Text(
            text = product.name,
            fontSize = 24.sp,
            color = colorResource(id = R.color.text_color)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = rememberAsyncImagePainter(topImage.value),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            Modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(product.imageData.size) {index ->
                Image(
                    painter = rememberAsyncImagePainter(product.imageData[index].url),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp, 100.dp)
                        .clickable { topImage.value = product.imageData[index].url },
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "${product.name}介紹",
            fontSize = 16.sp,
            color = colorResource(id = R.color.text_color)
        )
        Text(
            text = product.content,
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
            text = product.style,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color_light)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = product.remark,
            fontSize = 14.sp,
            color = colorResource(id = R.color.text_color)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 9.dp, end = 9.dp, bottom = 24.dp)
        ) {
            val context = LocalContext.current
            val intent =
                remember {
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://lin.ee/66ZtoWi")) }
            Button(
                onClick = { context.startActivity(intent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(
                    text = "立即聯絡",
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreen(
        Modifier,
        Product(
            id = 3,
            priority = 1,
            subtitle = "BABA 美式輕食",
            name = "環保純白包裝袋",
            content = "採用環保紙材，無有害化學物，符合環保要求、環境友好，為企業和消費者選擇綠色包裝的理想選擇",
            cost = "23",
            size = "large",
            style = "remark",
            remark = "",
            category = listOf(CategoryResponse(0, "食品"), CategoryResponse(0, "商品售賣")),
            imageData = listOf(
                ImageData(
                    1,
                    "https://api.waproject-gift.store/api/v1/static/3_1681371997.png"
                )
            )
        )
    )
}