package com.neome.feature.form.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

/**
 * Pure MVI Form Component.
 *
 * Responsibilities:
 * - Receives state from parent (screen/component)
 * - Receives formRef from parent for field operations
 * - Dispatches intents to parent
 * - No ViewModel dependency in component
 * - Fully testable and previewable
 *
 * Pure MVI Signature:
 * 1. state: FormState - Single source of truth (configuration)
 * 2. formRef: FormRef - Imperative API for field operations
 * 3. onIntent: (FormIntent) -> Unit - Single intent handler
 * 4. modifier: Modifier - Standard convention
 */
@Composable
fun Form(
    state: FormState,
    formRef: FormRef,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    FormContent(
        state = state,
        formRef = formRef,
        onIntent = onIntent,
        modifier = modifier
    )
}

/**
 * Stateless form content.
 * Pure presentation logic.
 */
@Composable
private fun FormContent(
    state: FormState,
    formRef: FormRef,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        val defnForm = state.defnForm

        if (defnForm != null) {
            // Form header
            Text(
                text = defnForm.label ?: defnForm.name?.value ?: "Form",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // For now, render simple text fields as placeholder
            // TODO: Replace with ComponentRendererFactory logic
            RenderSimpleFields(
                formRef = formRef,
                defnForm = defnForm,
                onIntent = onIntent
            )
        } else {
            // Error state when no form definition
            Text(
                text = "Error: Form definition not found",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}

/**
 * Simple field renderer for initial implementation.
 * Renders basic text fields for demonstration.
 * TODO: Replace with ComponentRendererFactory pattern.
 */
@Composable
private fun RenderSimpleFields(
    formRef: FormRef,
    defnForm: com.neome.api.meta.base.dto.DefnForm,
    onIntent: (FormIntent) -> Unit
) {
    // Get all components from the form (compMap is a Java Map)
    // Note: Cannot use .values directly due to Kotlin property name collision
    val components = mutableListOf<com.neome.api.meta.base.dto.DefnComp>().apply {
        defnForm.compMap.forEach { _, comp -> add(comp) }
    }

    components.forEachIndexed { index, defnComp ->
        // Skip hidden/invisible components
        if (defnComp.hidden == true || defnComp.invisible == true) {
            return@forEachIndexed
        }

        val fieldId = defnComp.name?.value ?: return@forEachIndexed
        val value by formRef.watch<String>(fieldId).collectAsStateWithLifecycle()

        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = value ?: "",
                onValueChange = { newValue ->
                    formRef.setValue(fieldId, newValue)
                    // Optionally emit Watch intent
                    // onIntent(FormIntent.Watch(fieldId, newValue, formRef.getValues()))
                },
                label = {
                    Text(defnComp.label ?: defnComp.name?.value ?: "")
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = defnComp.disabled != true,
                readOnly = defnComp.readOnly == true,
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}
