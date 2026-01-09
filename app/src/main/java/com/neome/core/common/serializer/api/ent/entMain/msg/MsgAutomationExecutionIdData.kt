package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entMain.msg.MsgAutomationExecutionId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.AutomationExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAutomationExecutionIdData(
    override val version: String? = null,
    @Serializable(with = AutomationExecutionIdSer::class) override val automationExecutionId: Types.AutomationExecutionId
) : MsgAutomationExecutionId
