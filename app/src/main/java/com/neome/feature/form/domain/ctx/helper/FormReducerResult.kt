package com.neome.feature.form.domain.ctx.helper

import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

data class FormReducerResult(
    val state: FormState,
    val intent: FormIntent? = null
)
