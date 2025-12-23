// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntAutomationStepAddSchedule : StudioEntAutomationStep() {
    var automationId: MetaIdAutomation? = null
    var dateTimeFieldId: MetaIdField? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var schedulerFieldId: MetaIdField? = null
    var sourceToTargetMappingVarId: MetaIdVar? = null
}
