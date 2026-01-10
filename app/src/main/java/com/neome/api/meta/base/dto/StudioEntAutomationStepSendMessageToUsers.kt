// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioEntAutomationStepSendMessageToUsers : StudioEntAutomationStepSendMessageWithSenderField {
    val dataSourceRoleIdSet: List<MetaIdRole>?
    val setOfUserVarId: MetaIdVar?
    val targetUserDataSourcePipelineVarId: MetaIdPipelineParam?
}
