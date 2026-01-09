package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgUserActionExecute
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutUserSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgUserActionExecuteData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    @Serializable(with = MetaIdLayoutUserSer::class) override val layoutId: Types.MetaIdLayoutUser
) : MsgUserActionExecute
