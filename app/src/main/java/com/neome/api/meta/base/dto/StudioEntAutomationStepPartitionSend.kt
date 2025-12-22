// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioEntAutomationStepPartitionSend : StudioEntAutomationStep() {
    var chatBubbleHeader: StudioDtoChatBubbleHeader? = null
    var senderFieldId: MetaIdField? = null
    var senderFormPipelineVarId: MetaIdPipelineParam? = null
    var senderRoleId: MetaIdRole? = null
    var targetGroupIdSet: MetaIdGroup[]? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
}
