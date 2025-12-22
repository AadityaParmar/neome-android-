// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam

class StudioEntAutomationStepRemoveField : StudioEntAutomationStep() {
    var formPipelineVarId: MetaIdPipelineParam? = null
    var removeFieldId: MetaIdField? = null
}
