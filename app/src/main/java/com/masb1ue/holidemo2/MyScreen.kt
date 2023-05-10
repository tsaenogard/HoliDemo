package com.masb1ue.holidemo2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyScreen(modifier: Modifier) {
    val context = LocalContext.current
    val intent =
        remember {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://lin.ee/66ZtoWi"))
        }
    Column(
        modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            item {
                MyScreenItem("APP版號", BuildConfig.VERSION_NAME, null) {}
                Divider()
            }

            item {
                MyScreenItem(
                    title = "聯繫好禮客服",
                    description = null,
                    icon = R.drawable.icon_line_rect
                ) {
                    context.startActivity(intent)
                }
                Divider()
            }
        }
    }
}

@Composable
fun MyScreenItem(title: String, description: String?, icon: Int?, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(73.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontSize = 16.sp, modifier = Modifier.weight(1.0f))
        description?.let {
            Text(text = description, fontSize = 16.sp)
        }
        icon?.let {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Preview
@Composable
fun MyScreenPreview() {
    MyScreen(Modifier)
}