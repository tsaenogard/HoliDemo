package com.masb1ue.holidemo2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masb1ue.holidemo2.data.SampleData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DrawerScreen(
    modifier: Modifier,
    onBackClick: () -> Unit,
    onConfirmClick: () -> Unit,
    onResetClick: () -> Unit,
    industry: List<String>,
    usage: List<String>,
    onIndustryCheck: (String) -> Unit,
    onUsageCheck: (String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "產業",
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
            SampleData.industryTitleList.forEach {
                val isChecked = industry.contains(it)
                ToggleButton(it, isChecked) { title, _ ->
                    onIndustryCheck(title)
                }
            }
        }
        Spacer(Modifier.height(32.dp))
        Text(
            text = "用途",
            color = Color(0xffa5a5a5),
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Spacer(Modifier.height(12.dp))
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top,
        ) {
            SampleData.usageTitleList.forEach {
                val isChecked = usage.contains(it)
                ToggleButton(it, isChecked) { title, _ ->
                    onUsageCheck(title)
                }
            }
        }
        Box(
            Modifier
                .weight(1.0f)
                .padding(16.dp)
        ) {
            Button(
                onClick = { onConfirmClick() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text(text = "確定", color = colorResource(id = R.color.text_color))
            }
        }
    }
}

@Composable
fun ToggleButton(
    content: String,
    checked: Boolean,
    onCheckedChange: (String, Boolean) -> Unit
) {
    val backgroundColor = if (checked) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        MaterialTheme.colorScheme.surface
    }
    val textColor = if (checked) {
        MaterialTheme.colorScheme.onSurfaceVariant
    } else {
        MaterialTheme.colorScheme.onSurface
    }
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            shape = RoundedCornerShape(10),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .background(backgroundColor)
                    .padding(12.dp, 11.dp)
                    .clickable { onCheckedChange(content, !checked) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = content,
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun DrawerScreenPreview() {
    val industry = listOf<String>("全部")
    val usage = listOf<String>("全部")
    DrawerScreen(Modifier, {}, {}, {}, industry, usage, {}, {})
}