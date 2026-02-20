package com.neome.feature.form.presentation.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.feature.form.presentation.state.FieldProperties

/**
 * Base component for all field components.
 *
 * Provides common styling and layout structure for form fields,
 * including consistent padding and spacing.
 *
 * @param modifier Modifier for customization
 * @param properties Field properties
 * @param content The field content to be wrapped
 */
@Composable
fun FieldBase(
    modifier: Modifier = Modifier,
    properties: FieldProperties,
    content: @Composable () -> Unit
) {
    // Early return if field is hidden
    if (properties.hidden) {
        return
    }

    Column(modifier = modifier.fillMaxWidth()) {
        content()
    }
}
