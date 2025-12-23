// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefSetOperationKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam

open class StudioEntAutomationStepUpdateFieldRefSet : StudioEntAutomationStep() {
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var operation: EnumDefnRefSetOperationKind? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var sortOrder: EnumDefnSortOrder? = null
    var sourceFieldId: MetaIdField? = null
    var targetFieldId: MetaIdField? = null
}
