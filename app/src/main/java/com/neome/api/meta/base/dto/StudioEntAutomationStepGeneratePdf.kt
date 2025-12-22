// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepGeneratePdf : StudioEntAutomationStepGenerateDocument() {
    var pdfFieldId: MetaIdField? = null
    var pdfFormId: MetaIdForm? = null
    var pdfFormMappingVarId: MetaIdVar? = null
}
