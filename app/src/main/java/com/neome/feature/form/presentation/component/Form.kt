package com.neome.feature.form.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.ctx.FormCtxImpl
import com.neome.feature.form.presentation.reducer.FormInitializer
import com.neome.feature.form.presentation.reducer.FormReducer
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.ref.FormRefImpl
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.utils.JsonParser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.encodeToString

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
    val defnFormStr = JsonParser.json.encodeToString(defnForm)
    println("===defnForm, ${defnFormStr}")
    // Internal state management
    val formStateFlow = remember { MutableStateFlow(FormState()) }
    val formState by formStateFlow.collectAsState()

    // Event dispatcher using reducer
    val dispatchEvent: (FormEvent) -> Unit = remember(defnForm, onIntent) {
        { event ->
            formStateFlow.update { currentState ->
                val result = FormReducer.reduce(currentState, event, defnForm)
                // Emit intent if present
                result.intent?.let { onIntent(it) }
                result.state
            }
        }
    }

    // Create FormRef and FormCtx
    val formRefImpl = remember(formStateFlow, dispatchEvent, coroutineScope) {
        FormRefImpl(
            formStateFlow = formStateFlow.asStateFlow(),
            dispatchEvent = dispatchEvent,
            coroutineScope = coroutineScope
        )
    }

    val formCtx = remember(formStateFlow, dispatchEvent, coroutineScope) {
        FormCtxImpl(
            formStateFlow = formStateFlow.asStateFlow(),
            dispatchEvent = dispatchEvent,
            coroutineScope = coroutineScope
        )
    }

    // Expose FormRef to parent
    LaunchedEffect(formRefImpl) {
        formRef.value = formRefImpl
    }

    // Cleanup FormRef on dispose
    DisposableEffect(Unit) {
        onDispose {
            formRef.value = null
        }
    }

    // Initialize form when defnForm or initialValue changes
    LaunchedEffect(defnForm, initialValue) {
        val initialState = FormInitializer.initializeFormState(defnForm, initialValue)
        formStateFlow.value = initialState
    }

    // Render form content
    FormContent(
        state = formState,
        defnForm = defnForm,
        onFieldEvent = remember(dispatchEvent) {
            { fieldEvent ->
                when (fieldEvent) {
                    is FieldEvent.ValueChanged -> {
                        dispatchEvent(
                            FormEvent.FieldValueChanged(
                                fieldId = fieldEvent.fieldId,
                                value = fieldEvent.value
                            )
                        )
                    }

                    is FieldEvent.Focused -> {
                        dispatchEvent(FormEvent.FieldFocused(fieldEvent.fieldId))
                    }

                    is FieldEvent.Blurred -> {
                        dispatchEvent(FormEvent.FieldBlurred(fieldEvent.fieldId))
                    }
                }
            }
        },
        formCtx = formCtx,
        modifier = modifier
    )
}

/**
 * Stateless form content.
 * Renders the root component using FieldFactory.
 */
@Composable
private fun FormContent(
    state: FormState,
    defnForm: DefnFormData,
    formCtx: FormCtx,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!state.isInitialized) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Loading form...",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            return@Column
        }

        val rootCompositeId = defnForm.displayCompositeId
        val rootComponent = defnForm.compMap[rootCompositeId]

        if (rootComponent != null) {
            FieldFactory(
                defnComp = rootComponent,
                defnForm = defnForm,
                formCtx = formCtx,
                onFieldEvent = onFieldEvent,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            println("=== FormContent: Root component not found")
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
