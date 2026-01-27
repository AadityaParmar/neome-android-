package com.neome.feature.form.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.presentation.components.Form

/**
 * Screen that hosts the Form component inside a minimal scaffold.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    modifier: Modifier = Modifier,
    viewModel: FormScreenViewModel = hiltViewModel()
) {
    val intentLog by viewModel.intentLog.collectAsStateWithLifecycle()

    val formRefState = remember { mutableStateOf<FormRef?>(null) }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Form(
                    defnForm = viewModel.defnForm,
                    formRef = formRefState,
                    onIntent = viewModel::onFormIntent,
                    modifier = Modifier.weight(1f)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    intentLog.takeLast(3).forEach { message ->
                        Text(
                            text = message,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Button(
                        onClick = { formRefState.value?.submit() },
                        enabled = formRefState.value != null,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Submit",
                            modifier = Modifier.size(18.dp)
                        )
                        Text(text = " Submit")
                    }
                }
            }
        }
    }
}
