package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Email field component for form.
 *
 * Email input field that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
 * Configured with email keyboard type and basic email validation.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing field state and other field values
 * @param modifier Modifier for customization
 */
@Composable
fun FieldEmail(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    // Use field controller composable with FieldValueEmailData type
    val fieldController = rememberFieldController<FieldValueEmailData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent,
        formCtx = formCtx
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Watch field properties reactively through controller
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    // Early return if field is hidden
    if (properties.hidden) return

    // Get current email value from FieldValueEmailData
    val currentValue = fieldController.fieldValue?.value ?: ""

    // Local state for email input
    var emailValue by remember(currentValue) { mutableStateOf(currentValue) }

    // Basic email validation regex
    val emailRegex = remember {
        Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    }

    // Handle email value changes
    fun onValueChange(newValue: String) {
        emailValue = newValue
        // Use controller's onChange callback with FieldValueEmailData
        val fieldValue = if (newValue.isEmpty()) null else FieldValueEmailData(newValue)

        fieldController.onChange(fieldValue)
    }

    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = emailValue,
            label = properties.label?.let { { Text(it) } },
            isError = emailValue.isNotEmpty() && !emailValue.contains("@"),
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier.fillMaxWidth(),
            onValueChange = ::onValueChange
        )
    }
}
