package com.masb1ue.holidemo2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactScreen(modifier: Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Column(Modifier.padding(32.dp)) {
            Spacer(Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "台北總公司聯絡電話",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "+ 886 - 2 - 000 - 222",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "台北總公司電子信箱",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "miiroxy921@gmail.com",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "台北總公司地址",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "新北市中和區\n中正路 45 巷 25 弄 6 號 5 樓",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "線上客服時間",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = "週一至週五 8:30 - 18:30",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
        Box(
            modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth()
                .padding(start = 9.dp, end = 9.dp, bottom = 24.dp)
        ) {
            val context = LocalContext.current
            val intent =
                remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://line.me/ti/p/OjTeDF_lL5")) }
            Button(
                onClick = { context.startActivity(intent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_line),
                    contentDescription = null
                )
                Text(
                    text = "聯絡我們",
                    fontWeight = FontWeight(500),
                    fontSize = 16.sp
                )
            }
        }

    }
}

@Preview
@Composable
fun ContactScreenPreview() {
    ContactScreen(Modifier)
}