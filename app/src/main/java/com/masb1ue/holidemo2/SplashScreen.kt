package com.masb1ue.holidemo2

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier, onFinishSplash: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(3000L)
        onFinishSplash()
    }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.launcher))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        contentScale = ContentScale.FillBounds,
        modifier = modifier.fillMaxSize()
    )
//    Box(
//        modifier = modifier
//            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.secondary)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = null,
//            modifier = Modifier.align(Alignment.Center)
//        )
//    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(Modifier, {})
}