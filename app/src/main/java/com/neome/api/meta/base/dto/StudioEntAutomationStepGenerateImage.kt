// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepGenerateImage : StudioEntAutomationStepGenerateDocument() {
    var imageFieldId: MetaIdField? = null
    var imageFormId: MetaIdForm? = null
    var imageFormMappingVarId: MetaIdVar? = null
}
