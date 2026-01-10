// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface StudioEntAutomationStepPartitionSend : StudioEntAutomationStep {
    val chatBubbleHeader: StudioDtoChatBubbleHeader?
    val senderFieldId: MetaIdField?
    val senderFormPipelineVarId: MetaIdPipelineParam?
    val senderRoleId: MetaIdRole?
    val targetGroupIdSet: List<MetaIdGroup>?
    val targetSpreadsheetId: MetaIdSpreadsheet?
}
