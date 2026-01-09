package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgLocationLogPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class MsgLocationLogPutData(
    override val entIdSet: Array<@Serializable(with = EntIdSer::class) Types.EntId>,
    override val name: String,
    override val summary: JsonElement
) : MsgLocationLogPut
