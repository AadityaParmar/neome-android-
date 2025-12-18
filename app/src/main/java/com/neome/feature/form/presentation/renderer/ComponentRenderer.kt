package com.neome.feature.form.presentation.renderer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef

/**
 * Component renderer interface
 * Each field type implements this to render its UI
 */
interface ComponentRenderer {
    @Composable
    fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    )
}
