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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neome.feature.form.presentation.form.Form
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.utils.PlusJsonParser
import com.neome.ui.theme.NeomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentTestingScreen(
    modifier: Modifier = Modifier
) {
    // Parse sample DefnForm from JSON
    val defnFormJson = PlusJsonParser.createSampleDefnForm()
    val defnForm = PlusJsonParser.parseDefnForm(defnFormJson)

    // Store formRef to access form imperatively
    var formRef by remember { mutableStateOf<FormRef?>(null) }
    var formDebugInfo by remember { mutableStateOf("FormRef not ready") }

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
            if (formRef != null) {
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
                                val values = formRef?.getValues()
                                formDebugInfo = "Form values: ${values?.valueMap?.size ?: 0} fields"
                                println(values?.valueMap)
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Get Values")
                        }

                        OutlinedButton(
                            onClick = {
                                // Example: Validate form
                                val isValid = formRef?.trigger() ?: false
                                formDebugInfo = "Form is ${if (isValid) "valid" else "invalid"}"
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Validate")
                        }

                        Button(
                            onClick = {
                                // Example: Reset form
                                formRef?.reset()
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
                defnForm = defnForm,
                formValueRaw = null,
                onNavigateBack = {},
                modifier = Modifier.padding(paddingValues),
                onFormRefReady = { ref ->
                    // Store the formRef when it's ready
                    formRef = ref
                    formDebugInfo =
                        "FormRef ready - ${ref.getValues()?.valueMap?.size ?: 0} fields initialized"
                }
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
