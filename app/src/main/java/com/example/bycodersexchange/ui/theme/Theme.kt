package com.example.bycodersexchange.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_0
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_4

val LightColorPalette = lightColors(
    primary = Color(0xFFFFC107),
    primaryVariant = Color(0xFFFFA000),
    secondary = Color(0xFFFFEB3B)
)

val Shapes = Shapes(
    small = RoundedCornerShape(DP_4),
    medium = RoundedCornerShape(DP_4),
    large = RoundedCornerShape(DP_0)
)