package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.ent.entMain.msg.MsgWorkflowExecutionStateList
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgWorkflowExecutionStateListData(
    override val filterWorkflowStateSet: Array<EnumWorkflowResultKind>? = null,
    override val from: String? = null,
    override val limit: Long? = null
) : MsgWorkflowExecutionStateList
