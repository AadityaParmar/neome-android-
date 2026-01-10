// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEditorLayoutRenderingMode
import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnLayoutFormEditor : DefnLayoutForm {
    val allowToSwitchLayoutIdSet: List<MetaIdLayoutForm>?
    val compositeIdSet: List<MetaIdComposite>?
    val editorLayoutRenderingMode: EnumDefnEditorLayoutRenderingMode?
    val formEditorLayoutIdSet: List<MetaIdLayoutForm>?
    val hideLabelCompositeIdSet: List<MetaIdComposite>?
    val label: String?
    val layoutCompositeMap: DefnMapOfLayoutFormEditorComposite?
    val navigationMode: EnumDefnWizardNavigationMode?
    val nextButtonLabel: String?
    val prevButtonLabel: String?
    val showStepper: Boolean?
}
