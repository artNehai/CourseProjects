package com.example.android.superheroes.ui.theme

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
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    inversePrimary = md_theme_light_secondary,
    secondary = md_theme_light_onSecondary,
    onSecondary = md_theme_light_secondaryContainer,
    secondaryContainer = md_theme_light_onSecondaryContainer,
    onSecondaryContainer = md_theme_light_tertiary,
    tertiary = md_theme_light_onTertiary,
    onTertiary = md_theme_light_tertiaryContainer,
    tertiaryContainer = md_theme_light_onTertiaryContainer,
    onTertiaryContainer = md_theme_light_error,
    background = md_theme_light_errorContainer,
    onBackground = md_theme_light_onError,
    surface = md_theme_light_onErrorContainer,
    onSurface = md_theme_light_background,
    surfaceVariant = md_theme_light_onBackground,
    onSurfaceVariant = md_theme_light_surface,
    surfaceTint = md_theme_light_onSurface,
    inverseSurface = md_theme_light_surfaceVariant,
    inverseOnSurface = md_theme_light_onSurfaceVariant,
    error = md_theme_light_outline,
    onError = md_theme_light_inverseOnSurface,
    errorContainer = md_theme_light_inverseSurface,
    onErrorContainer = md_theme_light_inversePrimary,
    outline = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,

    )

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    inversePrimary = md_theme_dark_secondary,
    secondary = md_theme_dark_onSecondary,
    onSecondary = md_theme_dark_secondaryContainer,
    secondaryContainer = md_theme_dark_onSecondaryContainer,
    onSecondaryContainer = md_theme_dark_tertiary,
    tertiary = md_theme_dark_onTertiary,
    onTertiary = md_theme_dark_tertiaryContainer,
    tertiaryContainer = md_theme_dark_onTertiaryContainer,
    onTertiaryContainer = md_theme_dark_error,
    background = md_theme_dark_errorContainer,
    onBackground = md_theme_dark_onError,
    surface = md_theme_dark_onErrorContainer,
    onSurface = md_theme_dark_background,
    surfaceVariant = md_theme_dark_onBackground,
    onSurfaceVariant = md_theme_dark_surface,
    surfaceTint = md_theme_dark_onSurface,
    inverseSurface = md_theme_dark_surfaceVariant,
    inverseOnSurface = md_theme_dark_onSurfaceVariant,
    error = md_theme_dark_outline,
    onError = md_theme_dark_inverseOnSurface,
    errorContainer = md_theme_dark_inverseSurface,
    onErrorContainer = md_theme_dark_inversePrimary,
    outline = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

@Composable
fun CourseProjectsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}