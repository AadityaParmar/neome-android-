package com.neome.core.common.serializer.api.app.cli.msg

import com.neome.api.app.cli.msg.MsgNeoScriptPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class MsgNeoScriptPutData(
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val cliCodeId: String? = null,
    override val displayDateFormat: String,
    @Serializable(with = MetaIdModuleSer::class) override val moduleId: Types.MetaIdModule? = null,
    override val neoScriptOrUserMessage: String,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey
) : MsgNeoScriptPut
