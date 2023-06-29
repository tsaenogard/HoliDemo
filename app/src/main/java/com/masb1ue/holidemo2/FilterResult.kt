package com.masb1ue.holidemo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterResult(
    modifier: Modifier,
    viewModel: SearchViewModel,
    onBackClick: () -> Unit,
    onResetClick: () -> Unit,
    productList: List<Product>,
    onProductClick: (Product) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(64.dp)
//                .background(MaterialTheme.colorScheme.primary),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.icon_left),
//                contentDescription = null,
//                contentScale = ContentScale.FillHeight,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .clickable {
//                        onBackClick()
//                    }
//            )
//        }
//        Spacer(Modifier.height(20.dp))
        if (viewModel.isLoading) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.searching))
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    contentScale = ContentScale.Fit
                )
            }
        } else {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "已選",
                    color = Color(0xffa5a5a5),
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1.0f),
                    fontWeight = FontWeight(700),
                )
                Text(
                    text = "重設篩選條件",
                    color = Color(0xffa5a5a5),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.clickable { onResetClick() }
                )
            }
            Spacer(Modifier.height(12.dp))
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.Top,
            ) {
                if (viewModel.industryList.size == SampleData.industryList.size) {
                    ToggleButton("全部產業", true) { _, _ -> }
                } else {
                    viewModel.industryList.forEach {
                        ToggleButton(it, true) { _, _ -> }
                    }
                }
                if (viewModel.usageList.size == SampleData.usageList.size) {
                    ToggleButton("全部用途", true) { _, _ -> }
                } else {
                    viewModel.usageList.forEach {
                        ToggleButton(it, true) { _, _ -> }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (productList.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(productList.size) { index ->
                        Column(
                            Modifier
                                .clickable { onProductClick.invoke(productList[index]) },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    productList[index].imageData.firstOrNull()?.url ?: ""
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(160.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = productList[index].name,
                                fontSize = 14.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.height(35.dp)
                            )
                        }
                    }
                }
            } else {
                Text(text = "沒有資料")
            }
        }
    }
}