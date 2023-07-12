package com.masb1ue.holidemo2.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = ColorFFFFFF,
    onPrimary = Color171614,
    secondary = ColorF6EBE4,
    onSecondary = ColorE2CDC7,
    background = ColorFDFAF7,
    onBackground = Color171614,
    inversePrimary = ColorFFFFFF,
)


private val LightColorScheme = lightColorScheme(
    //topBar
    primary = ColorFFFFFF,
    onPrimary = Color171614,
    primaryContainer = ColorFFFFFF,
    //bottom bar
    secondary = ColorF6EBE4,
    onSecondary = Color171614,
    secondaryContainer = ColorE2CDC7,
    //main
    tertiary = ColorF6EBE4,
    onTertiary = Color171614,
    onTertiaryContainer = Color9A9999,
    //組件、
    surface = ColorFFFFFF,
    onSurface = Color171614,
    //多選
    surfaceVariant = Color171614,
    onSurfaceVariant = ColorF2F0ED,
    background = ColorFDFAF7,
    onBackground = Color171614,
)

@Composable
fun HoliDemo2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            dynamicLightColorScheme(context)
            LightColorScheme
        }
        darkTheme -> LightColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = LightColorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}