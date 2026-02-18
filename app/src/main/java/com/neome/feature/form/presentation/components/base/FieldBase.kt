package com.neome.feature.form.presentation.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Base component for all field components.
 *
 * Provides common styling and layout structure for form fields,
 * including consistent padding and spacing.
 *
 * @param modifier Modifier for customization
 * @param content The field content to be wrapped
 */
@Composable
fun FieldBase(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        content()
    }
}
