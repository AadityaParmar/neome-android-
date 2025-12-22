// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEditorLayoutRenderingMode
import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdLayoutForm

class StudioDtoLayoutFormEditor : StudioDtoLayoutForm() {
    var allowToSwitchLayoutIdSet: MetaIdLayoutForm[]? = null
    var editorLayoutRenderingMode: EnumDefnEditorLayoutRenderingMode? = null
    var formEditorLayoutIdSet: MetaIdLayoutForm[]? = null
    var hideLabelCompositeIdSet: MetaIdComposite[]? = null
    var label: string? = null
    var layoutCompositeMap: StudioMapOfLayoutFormEditorComposite? = null
    var navigationMode: EnumDefnWizardNavigationMode? = null
    var nextButtonLabel: string? = null
    var prevButtonLabel: string? = null
    var showStepper: boolean? = null
}
