package com.masb1ue.holidemo2

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.masb1ue.holidemo2.data.Product
import com.masb1ue.holidemo2.data.SampleData
import kotlinx.coroutines.launch
import java.util.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    onCategoryClick: (String) -> Unit,
    onDemoClick: (Product) -> Unit,
    onFilterClick: (Boolean) -> Unit,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .height(185.dp)
        ) {
            val pagerState = rememberPagerState()
            val coroutineScope = rememberCoroutineScope()
            DisposableEffect(Unit) {
                val timer = Timer()
                timer.schedule(object : TimerTask() {
                    override fun run() {
                        coroutineScope.launch {
                            if (pagerState.currentPage >= 2) {
                                pagerState.animateScrollToPage(0)
                            } else {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    }
                }, 3000, 3000)
                onDispose {
                    timer.cancel()
                }
            }
            HorizontalPager(
                count = SampleData.bannerList.size,
                state = pagerState
            ) { index ->
                Image(
                    painter = painterResource(id = SampleData.bannerList[index]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        LazyRow(
            Modifier
                .fillMaxWidth()
                .height(94.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(SampleData.industryTitleList.size) { index ->
                Column(
                    Modifier
                        .fillMaxHeight()
                        .clickable { onCategoryClick.invoke(SampleData.industryTitleList[index]) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Image(
                        painter = painterResource(id = SampleData.categoryImgList[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(CircleShape)
                            .weight(2f),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = SampleData.industryTitleList[index],
                        modifier = Modifier.weight(1f),
                        fontSize = 14.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(thickness = 1.dp, color = Color(0xFFEAE6E5))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "精選作品",
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable {
                        onFilterClick(true)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "篩選", fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
                Image(
                    painter = painterResource(id = R.drawable.icon_menu),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp, 48.dp)
                )
            }

        }
        Divider(thickness = 1.dp, color = Color(0xFFEAE6E5))
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .height(430.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(
                16.dp
            )
        ) {
            items(SampleData.homeProductList.size) { index ->
                Column(
                    Modifier
                        .background(Color(0xFFFFFFFF))
                        .clickable { onDemoClick.invoke(SampleData.homeProductList[index]) },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = SampleData.homeProductImageList[index]),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .aspectRatio(1f)
                    )
                    Text(
                        text = SampleData.homeProductList[index].name,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(Modifier, {}, {}, {})
}

