package com.masb1ue.holidemo2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.masb1ue.holidemo2.api.SearchViewModel
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CategoryScreen(
    modifier: Modifier,
    category: String,
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
        Row(
            Modifier
                .height(60.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.food), contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = category, fontSize = 24.sp)
        }
        TabRow(selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .height(4.dp)
                        .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                        .padding(horizontal = 28.dp)
                        .background(color = Color(0xFFA26964))
                )
            }) {
            SampleData.tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                    selectedContentColor = Color(0xFFA26964),
                    unselectedContentColor = Color(0xFF49454F)

                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPager(
            count = SampleData.tabs.size,
            state = pagerState
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(productList.size) { index ->
                    Column(
                        Modifier
                            .clickable { onProductClick.invoke(productList[index]) },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(productList[index].image[0]),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(160.dp)
                                .width(160.dp)
                        )
                        Text(
                            text = productList[index].subtitle,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.height(35.dp)
                        )
                    }
                }
            }
        }
    }
}

