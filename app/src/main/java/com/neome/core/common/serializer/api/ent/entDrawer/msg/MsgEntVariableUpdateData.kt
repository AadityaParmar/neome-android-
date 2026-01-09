package com.neome.core.common.serializer.api.ent.entDrawer.msg

import com.neome.api.ent.entDrawer.msg.MsgEntVariableUpdate
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class MsgEntVariableUpdateData(
    override val variableObjectMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, JsonElement>? = null
) : MsgEntVariableUpdate
