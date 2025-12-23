// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEditorLayoutRenderingMode
import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class StudioDtoLayoutFormEditor : StudioDtoLayoutForm() {
    var allowToSwitchLayoutIdSet: Array<MetaIdLayoutForm>? = null
    var editorLayoutRenderingMode: EnumDefnEditorLayoutRenderingMode? = null
    var formEditorLayoutIdSet: Array<MetaIdLayoutForm>? = null
    var hideLabelCompositeIdSet: Array<MetaIdComposite>? = null
    var label: String? = null
    var layoutCompositeMap: StudioMapOfLayoutFormEditorComposite? = null
    var navigationMode: EnumDefnWizardNavigationMode? = null
    var nextButtonLabel: String? = null
    var prevButtonLabel: String? = null
    var showStepper: Boolean? = null
}
