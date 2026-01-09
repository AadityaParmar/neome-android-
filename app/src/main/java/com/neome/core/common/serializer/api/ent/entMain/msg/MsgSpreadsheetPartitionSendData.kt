package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgSpreadsheetPartitionSend
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetPartitionSendData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = GroupIdSer::class) override val toGroupId: Types.GroupId
) : MsgSpreadsheetPartitionSend
