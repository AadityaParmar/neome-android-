package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumAutomationStateFilterKind
import com.neome.api.ent.entMain.msg.MsgAutomationStateInfoList
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgAutomationStateInfoListData(
    override val filterAutomationStateSet: Array<EnumAutomationStateFilterKind>? = null,
    override val from: String? = null,
    override val limit: Long? = null
) : MsgAutomationStateInfoList
