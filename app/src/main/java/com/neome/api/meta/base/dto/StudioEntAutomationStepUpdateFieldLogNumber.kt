// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class StudioEntAutomationStepUpdateFieldLogNumber : StudioEntAutomationStep() {
    var customMessageVarId: StudioValueVarIdText? = null
    var operation: EnumDefnLogOperationKind? = null
    var rowFieldId: MetaIdField? = null
    var sourcePipelineVarId: MetaIdPipelineParam? = null
    var targetFieldId: MetaIdField? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
    var value: StudioBuildArgBinderHolder? = null
}
