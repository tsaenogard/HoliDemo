package com.masb1ue.holidemo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CategoryScreen(
    modifier: Modifier,
    isLoading: Boolean,
    categoryIndex: Int,
    productList: List<Product>,
    onProductClick: (Product) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        val pagerState = rememberPagerState()
        val scope = rememberCoroutineScope()
        val usageList = productList.map { product ->
            product.category.filter {
                it.categoryID == 1
            }
        }.flatten().distinct().map { it.content }
        Row(
            Modifier
                .height(60.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = SampleData.categoryImgList[categoryIndex]),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = SampleData.industryTitleList[categoryIndex], fontSize = 24.sp)
        }
        if (productList.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(4.dp)
                            .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                            .padding(horizontal = 28.dp)
                            .background(color = Color(0xFFA26964))
                    )
                },
                containerColor = MaterialTheme.colorScheme.background
            ) {
                usageList.forEachIndexed { index, title ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        selectedContentColor = Color(0xFFA26964),
                        unselectedContentColor = Color(0xFF49454F)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalPager(
                count = usageList.size,
                state = pagerState
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val products = productList.filter { product ->
                        product.category.any { it.content == usageList[pagerState.currentPage] }
                    }
                    items(products.size) { index ->
                        Column(
                            Modifier
                                .clickable { onProductClick.invoke(products[index]) },
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    products[index].imageData.firstOrNull()?.url ?: ""
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .height(160.dp)
                                    .width(160.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = products[index].name,
                                fontSize = 14.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.height(35.dp)
                            )
                        }
                    }
                }
            }
        } else {
            if (isLoading) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
            } else {
                Text(text = "沒有資料")
            }
        }
    }
}

@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(Modifier, false, 0, listOf<Product>(), {})
}


