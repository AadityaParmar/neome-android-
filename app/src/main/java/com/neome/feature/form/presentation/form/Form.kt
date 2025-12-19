package com.neome.feature.form.presentation.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRendererFactory
import com.neome.feature.form.presentation.state.FormBase
import com.neome.feature.form.presentation.state.FormIntent


/**
 * Pure MVI Form Component
 *
 * Renders a dynamic form based on DefnForm structure using ComponentRendererFactory
 *
 * @param state FormBase containing defnForm and initialFormValue (can be FormProps or FormState)
 * @param formRef FormRef for imperative field operations (provided by parent)
 * @param onIntent Intent handler for Submit and Watch events
 * @param modifier Standard Compose modifier
 */
@Composable
fun Form(
    state: FormBase,
    formRef: FormRef?,
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
        val rootComponent = defnForm?.compMap?.get(defnForm.displayCompositeId)

        when {
            // Form not initialized
            defnForm == null -> {
                Text(
                    text = "Form not initialized",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
            // FormRef not available
            formRef == null -> {
                Text(
                    text = "FormRef not available",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
            // Root component not found
            rootComponent == null -> {
                Text(
                    text = "Error: Root component not found in form definition",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            }
            // Render form using ComponentRendererFactory
            else -> {
                ComponentRendererFactory.Render(
                    defnComp = rootComponent,
                    defnForm = defnForm,
                    formRef = formRef,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
