package com.neome.feature.form.presentation.form

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.feature.form.presentation.renderer.ComponentRendererFactory
import com.neome.feature.form.presentation.state.FormEffect
import com.neome.feature.form.presentation.state.FormEvent

/**
 * Dynamic form screen
 * Renders form based on DefnForm structure
 */
@Composable
fun Form(
    defnForm: DefnForm,
    formValueRaw: FormValueRaw? = null,
    viewModel: FormViewModel = viewModel(),
    onNavigateBack: () -> Unit = {}
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    // Initialize form
    LaunchedEffect(defnForm) {
        viewModel.initializeFromDefnForm(defnForm, formValueRaw)
    }

    // Collect state
    val formState by viewModel.formState.collectAsStateWithLifecycle()
    val formRef = viewModel.formRef

    // Handle effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is FormEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(effect.message)
                }

                is FormEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }

                is FormEffect.ShowError -> {
                    snackbarHostState.showSnackbar(effect.message)
                }

                is FormEffect.NavigateBack -> {
                    onNavigateBack()
                }

                is FormEffect.NavigateToDetail -> {
                    // TODO: Handle navigation
                }
            }
        }
    }

    FormContent(
        defnForm = defnForm,
        formRef = formRef,
        isSubmitting = formState.isSubmitting,
        isValid = formState.isValid,
        snackbarHostState = snackbarHostState,
        onSubmit = { viewModel.onEvent(FormEvent.Submit) },
        onReset = { viewModel.onEvent(FormEvent.Reset) }
    )
}

@Composable
private fun FormContent(
    defnForm: DefnForm,
    formRef: com.neome.feature.form.presentation.ref.FormRef,
    isSubmitting: Boolean,
    isValid: Boolean,
    snackbarHostState: SnackbarHostState,
    onSubmit: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {


        // Render root component
        val rootComponent = defnForm.compMap[defnForm.displayCompositeId]
        if (rootComponent != null) {
            ComponentRendererFactory.render(
                defnComp = rootComponent,
                defnForm = defnForm,
                formRef = formRef,
                modifier
            )
        } else {
            Text(
                text = "Error: Root component not found",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}
