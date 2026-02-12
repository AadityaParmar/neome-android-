package com.neome.feature.form.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.domain.ctx.FormCtxImpl
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.domain.ref.FormRef
import com.neome.feature.form.domain.util.FilterForm
import com.neome.feature.form.presentation.components.base.FieldFactory
import com.neome.feature.form.presentation.sample.FormSampleDataFactory
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

/**
 * Pure MVI Form Component.
 *
 * An embedded form component that:
 * - Receives configuration from parent (defnForm, initialValue)
 * - Manages centralized state internally using FormReducer
 * - Emits intents to parent (Submit, Watch)
 * - Exposes FormRef for external access
 *
 * @param defnForm Form definition containing field configurations
 * @param initialValue Initial form values (optional)
 * @param formRef MutableState to expose FormRef to parent
 * @param onIntent Callback for form intents (Submit, Watch)
 * @param modifier Modifier for customization
 */
@Composable
fun Form(
    defnForm: DefnFormData,
    initialValue: FormValueRawData? = null,
    formRef: MutableState<FormRef?>,
    onIntent: (FormIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val currentOnIntent by rememberUpdatedState(onIntent)

    val formCtx = remember(defnForm, initialValue) {
        FormCtxImpl(
            defnForm = defnForm,
            initialValue = initialValue,
            coroutineScope = coroutineScope,
            onIntent = { currentOnIntent(it) }
        )
    }

    val formState by formCtx.stateFlow.collectAsState()

    val formRefImpl = remember(formCtx) {
        formCtx.createFormRef()
    }

    LaunchedEffect(formRefImpl) {
        formRef.value = formRefImpl
    }

    LaunchedEffect(Unit) {
        val callerEnt = FormSampleDataFactory.getSampleCallerEnt()

        val filteredForm = FilterForm.prepare(defnForm, callerEnt)

    }


    DisposableEffect(Unit) {
        onDispose {
            formRef.value = null
        }
    }

    CompositionLocalProvider(LocalFormCtx provides formCtx) {
        FormContent(
            state = formState,
            defnForm = defnForm,
            onFieldEvent = remember(formCtx) {
                { fieldEvent ->
                    when (fieldEvent) {
                        is FieldEvent.ValueChanged -> {
                            formCtx.dispatch(
                                FormEvent.FieldValueChanged(
                                    fieldId = fieldEvent.fieldId,
                                    value = fieldEvent.value
                                )
                            )
                        }

                        is FieldEvent.Focused -> {
                            formCtx.dispatch(FormEvent.FieldFocused(fieldEvent.fieldId))
                        }

                        is FieldEvent.Blurred -> {
                            formCtx.dispatch(FormEvent.FieldBlurred(fieldEvent.fieldId))
                        }
                    }
                }
            },
            modifier = modifier
        )
    }
}

/**
 * Stateless form content with lazy rendering optimization.
 * Renders the root component using FieldFactory with LazyColumn for large forms.
 *
 * PERFORMANCE OPTIMIZATION:
 * - Uses LazyColumn for efficient rendering of large forms
 * - Only renders visible items on screen
 * - Stable keys prevent unnecessary recomposition
 */
@Composable
private fun FormContent(
    state: FormState,
    defnForm: DefnFormData,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    if (!state.isInitialized) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Loading form...",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        return
    }

    val rootCompositeId = defnForm.displayCompositeId
    val rootComponent = defnForm.compMap[rootCompositeId]

    if (rootComponent == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Error: Root component not found",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
        }
        return
    }

    FieldFactory(
        defnComp = rootComponent,
        defnForm = defnForm,
        onFieldEvent = onFieldEvent,
        modifier = modifier.fillMaxWidth()
    )
}
