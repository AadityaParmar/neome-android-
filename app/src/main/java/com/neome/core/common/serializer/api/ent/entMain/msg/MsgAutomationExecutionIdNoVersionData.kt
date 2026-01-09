package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgAutomationExecutionIdNoVersion
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.AutomationExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAutomationExecutionIdNoVersionData(
    @Serializable(with = AutomationExecutionIdSer::class) override val automationExecutionId: Types.AutomationExecutionId
) : MsgAutomationExecutionIdNoVersion
