package com.neome.feature.componentshowcase.presentation.testing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.form.presentation.component.Form
import com.neome.junk.TestKotlinxJsonParser
import com.neome.ui.theme.NeomeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentTestingScreen(
    modifier: Modifier = Modifier,
    viewModel: ComponentTestingViewModel = hiltViewModel()
) {
    // Collect form state
    val formState by viewModel.formState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Test buttons section
            Button(
                onClick = { TestKotlinxJsonParser.testWithMapper() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Test Kotlinx + Mapper → DefnForm")
            }

            Button(
                onClick = { TestKotlinxJsonParser.compareAllParsers() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Compare: Gson vs Kotlinx")
            }

            // Render Form component with Pure MVI signature
            Form(
                state = formState,
                formRef = viewModel.formRef,
                onIntent = viewModel::onFormIntent,
                modifier = Modifier.weight(1f)
            )
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
