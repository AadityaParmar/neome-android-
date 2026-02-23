package com.neome.feature.form.domain.ctx.base

import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

data class FormReducerResult(
    val state: FormState,
    val intents: List<FormIntent> = emptyList()
)
