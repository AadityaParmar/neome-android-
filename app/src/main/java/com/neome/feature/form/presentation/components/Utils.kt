package com.neome.feature.form.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.neome.api.meta.base.Types.EnumDefnThemeColor
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData

/**
 * Resolves a [DefnDtoColorData] to a Compose [Color].
 *
 * Maps [EnumDefnThemeColor] semantic names to [MaterialTheme.colorScheme] tokens
 * and named colors to standard Compose [Color] constants.
 * Returns [MaterialTheme.colorScheme.onSurface] as fallback when color is null or unmapped.
 */
@Composable
fun resolveThemeColor(color: DefnDtoColorData?): Color {
    val themeColor = color?.value ?: return MaterialTheme.colorScheme.onSurface
    val colorScheme = MaterialTheme.colorScheme

    return when (themeColor) {
        // Semantic theme colors
        EnumDefnThemeColor.primary -> colorScheme.primary
        EnumDefnThemeColor.secondary -> colorScheme.secondary
        EnumDefnThemeColor.error -> colorScheme.error
        EnumDefnThemeColor.info -> colorScheme.tertiary
        EnumDefnThemeColor.success -> Color(0xFF4CAF50)
        EnumDefnThemeColor.warning -> Color(0xFFFF9800)

        // Text variants
        EnumDefnThemeColor.textPrimary -> colorScheme.onSurface
        EnumDefnThemeColor.textSecondary -> colorScheme.onSurfaceVariant
        EnumDefnThemeColor.textDisabled -> colorScheme.onSurface.copy(alpha = 0.38f)
        EnumDefnThemeColor.textInverse -> colorScheme.inverseOnSurface

        // Light variants
        EnumDefnThemeColor.primaryLight -> colorScheme.primaryContainer
        EnumDefnThemeColor.secondaryLight -> colorScheme.secondaryContainer
        EnumDefnThemeColor.successLight -> Color(0xFFC8E6C9)
        EnumDefnThemeColor.errorLight -> colorScheme.errorContainer
        EnumDefnThemeColor.infoLight -> colorScheme.tertiaryContainer
        EnumDefnThemeColor.warningLight -> Color(0xFFFFE0B2)

        // Dark variants
        EnumDefnThemeColor.primaryDark -> colorScheme.onPrimaryContainer
        EnumDefnThemeColor.secondaryDark -> colorScheme.onSecondaryContainer
        EnumDefnThemeColor.successDark -> Color(0xFF2E7D32)
        EnumDefnThemeColor.errorDark -> colorScheme.onErrorContainer
        EnumDefnThemeColor.infoDark -> colorScheme.onTertiaryContainer
        EnumDefnThemeColor.warningDark -> Color(0xFFE65100)

        // Named colors
        EnumDefnThemeColor.amber -> Color(0xFFFFC107)
        EnumDefnThemeColor.black -> Color.Black
        EnumDefnThemeColor.blue -> Color(0xFF2196F3)
        EnumDefnThemeColor.cyan -> Color(0xFF00BCD4)
        EnumDefnThemeColor.deepOrange -> Color(0xFFFF5722)
        EnumDefnThemeColor.deepPurple -> Color(0xFF673AB7)
        EnumDefnThemeColor.green -> Color(0xFF4CAF50)
        EnumDefnThemeColor.grey -> Color(0xFF9E9E9E)
        EnumDefnThemeColor.indigo -> Color(0xFF3F51B5)
        EnumDefnThemeColor.lightBlue -> Color(0xFF03A9F4)
        EnumDefnThemeColor.lightGreen -> Color(0xFF8BC34A)
        EnumDefnThemeColor.lime -> Color(0xFFCDDC39)
        EnumDefnThemeColor.orange -> Color(0xFFFF9800)
        EnumDefnThemeColor.pink -> Color(0xFFE91E63)
        EnumDefnThemeColor.purple -> Color(0xFF9C27B0)
        EnumDefnThemeColor.red -> Color(0xFFF44336)
        EnumDefnThemeColor.teal -> Color(0xFF009688)
        EnumDefnThemeColor.white -> Color.White
        EnumDefnThemeColor.yellow -> Color(0xFFFFEB3B)

        // Transparent
        EnumDefnThemeColor.transparent -> Color.Transparent
    }
}
