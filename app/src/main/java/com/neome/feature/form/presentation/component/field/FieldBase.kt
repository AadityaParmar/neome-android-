package com.neome.feature.form.presentation.component.field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        content()
    }
}