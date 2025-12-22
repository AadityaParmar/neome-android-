package com.neome.feature.form.presentation.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FormViewModel : ViewModel() {

    private val _state = MutableStateFlow(FormState())
    val state = _state.asStateFlow()

    private val _effect = Channel<FormEffect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: FormEvent) {
        when (event) {
            is FormEvent.Submit -> submitForm()
            is FormEvent.Reset -> resetForm()
        }
    }

    private fun submitForm() {
        viewModelScope.launch {
            // Add form submission logic here later
            try {
                _effect.send(FormEffect.ShowSnackbar("Form submitted successfully"))
            } catch (e: Exception) {
                _effect.send(FormEffect.ShowSnackbar("Failed to submit form"))
            }
        }
    }

    private fun resetForm() {
        _state.update { FormState() }
    }
}
