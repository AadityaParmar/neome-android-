package com.neome.feature.form.presentation.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.neome.feature.form.presentation.sample.FormSampleDataFactory
import com.neome.feature.form.presentation.state.FormIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.JsonElement
import javax.inject.Inject

@HiltViewModel
class FormScreenViewModel @Inject constructor() : ViewModel() {

    val defnForm = FormSampleDataFactory.createTextForm()

    private val _intentLog = MutableStateFlow<List<String>>(emptyList())
    val intentLog = _intentLog.asStateFlow()

    fun onFormIntent(intent: FormIntent) {
        val message = when (intent) {
            is FormIntent.Submit -> {
                "Submit → ${intent} fields"
            }

            is FormIntent.Watch -> {
                val value = intent.fieldValue?.let(JsonElement::toString) ?: "null"
                "Watch → ${intent.fieldId.getId()} = $value"
            }

            is FormIntent.ValidationStateChanged -> {
                "Validation → valid=${intent.isValid} errors=${intent.hasErrors}"
            }

            is FormIntent.SendBtnStateChanged -> {
                "SendBtn → enabled=${intent.enabled}"
            }
        }

        Log.d("FormScreen", message)
        _intentLog.value = (_intentLog.value + message).takeLast(5)
    }
}
