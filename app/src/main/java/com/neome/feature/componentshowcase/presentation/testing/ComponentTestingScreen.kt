package com.neome.feature.componentshowcase.presentation.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.feature.form.presentation.form.Form
import com.neome.feature.form.presentation.form.FormViewModel
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.utils.PlusJsonParser
import com.neome.ui.theme.NeomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentTestingScreen(
    modifier: Modifier = Modifier,
    viewModel: FormViewModel = viewModel()
) {
    // Parse sample DefnForm from JSON
    val defnFormJson = PlusJsonParser.createSampleDefnForm()
    val defnForm = PlusJsonParser.parseDefnForm(defnFormJson)

    // Initialize ViewModel with DefnForm
    LaunchedEffect(defnForm) {
        if (defnForm != null) {
            viewModel.initializeFromDefnForm(defnForm)
        }
    }

    // Collect state from ViewModel
    val state by viewModel.formState.collectAsStateWithLifecycle()
    val formRef = viewModel.formRef

    var formDebugInfo by remember { mutableStateOf("Loading form...") }

    // Update debug info when state changes
    LaunchedEffect(state.defnForm) {
        if (state.defnForm != null) {
            formDebugInfo =
                "FormRef ready - ${formRef.getValues()?.valueMap?.size ?: 0} fields initialized"
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Component Testing") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            // Example controls using FormRef
            if (state.defnForm != null) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = formDebugInfo,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedButton(
                            onClick = {
                                // Example: Get all form values
                                val values = formRef.getValues()
                                formDebugInfo = "Form values: ${values?.valueMap?.size ?: 0} fields"
                                println("Form values: ${values?.valueMap}")
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Get Values")
                        }

                        OutlinedButton(
                            onClick = {
                                // Example: Validate form
                                val isValid = formRef.trigger()
                                formDebugInfo = "Form is ${if (isValid) "valid" else "invalid"}"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Validate")
                        }

                        Button(
                            onClick = {
                                // Example: Reset form
                                formRef.reset()
                                formDebugInfo = "Form reset to defaults"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Reset")
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        if (defnForm != null) {
            Form(
                state = state,
                formRef = formRef,
                onIntent = { intent ->
                    when (intent) {
                        is FormIntent.Submit -> {
                            // Handle form submission
                            formDebugInfo =
                                "Form submitted with ${intent.formValue.valueMap.size} fields"
                            println("Form submitted: ${intent.formValue}")
                        }

                        is FormIntent.Watch -> {
                            // Handle field changes
                            formDebugInfo =
                                "Field '${intent.fieldId}' changed to: ${intent.fieldValue}"
                            println("Field watch: ${intent.fieldId} = ${intent.fieldValue}")
                        }
                    }
                },
                modifier = Modifier.padding(paddingValues)
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Error loading form",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Check logcat for details",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComponentTestingScreenPreview() {
    NeomeTheme {
        Surface {
            ComponentTestingScreen()
        }
    }
}
