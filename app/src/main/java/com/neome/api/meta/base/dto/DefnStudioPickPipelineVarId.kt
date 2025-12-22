// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPipelineFormKind
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdStep

class DefnStudioPickPipelineVarId : DefnFieldEditable() {
    var automationEventId: MetaIdEvent? = null
    var automationId: MetaIdAutomation? = null
    var automationStepId: MetaIdStep? = null
    var excludePipelineVarIdSet: MetaIdPipelineVar[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var multiSelect: boolean? = null
    var pipelineFormKind: EnumDefnPipelineFormKind? = null
}
