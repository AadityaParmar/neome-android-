package com.neome.core.common.serializer.api.app.cli.msg

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.cli.msg.MsgNeoScriptCtxSet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.app.base.dto.DtoNeoScriptData
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgNeoScriptCtxSetData(
    override val cliCodeId: String? = null,
    override val ctx: DtoNeoScriptData,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null
) : MsgNeoScriptCtxSet
