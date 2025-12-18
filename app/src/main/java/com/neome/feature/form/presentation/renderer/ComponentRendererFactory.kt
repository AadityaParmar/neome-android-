package com.neome.feature.form.presentation.renderer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.composite.FieldSection
import com.neome.feature.form.presentation.renderer.composite.FieldTab
import com.neome.feature.form.presentation.renderer.field.FieldBool
import com.neome.feature.form.presentation.renderer.field.FieldDate
import com.neome.feature.form.presentation.renderer.field.FieldEmail
import com.neome.feature.form.presentation.renderer.field.FieldNumber
import com.neome.feature.form.presentation.renderer.field.FieldPhone
import com.neome.feature.form.presentation.renderer.field.FieldPickText
import com.neome.feature.form.presentation.renderer.field.FieldText
import com.neome.feature.form.presentation.renderer.field.UnsupportedRenderer

/**
 * Factory pattern for rendering components
 * Maps component types to their renderers
 */
object ComponentRendererFactory {

    @Composable
    fun render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier = Modifier
    ) {
        // Check visibility
        if (defnComp.hidden == true || defnComp.invisible == true) return

        val renderer = getRenderer(defnComp.type)
        renderer.Render(defnComp, defnForm, formRef, modifier)
    }

    private fun getRenderer(type: EnumDefnCompType): ComponentRenderer {
        return when (type) {
            // Composites
            EnumDefnCompType.tab -> FieldTab
            EnumDefnCompType.section -> FieldSection
            // EnumDefnCompType.grid -> FieldGrid  // TODO: Implement later

            // Text fields
            EnumDefnCompType.text -> FieldText
            EnumDefnCompType.email -> FieldEmail
            EnumDefnCompType.mobileNumber -> FieldPhone  // phone is 'mobileNumber' in enum
            // EnumDefnCompType.hyperlink -> FieldUrl  // TODO: Implement later

            // Number fields
            EnumDefnCompType.number -> FieldNumber
            // EnumDefnCompType.currency -> FieldCurrency  // TODO: Implement later

            // Other fields
            EnumDefnCompType.bool -> FieldBool
            EnumDefnCompType.pickText -> FieldPickText
            EnumDefnCompType.date -> FieldDate

            // Unsupported
            else -> UnsupportedRenderer
        }
    }
}
