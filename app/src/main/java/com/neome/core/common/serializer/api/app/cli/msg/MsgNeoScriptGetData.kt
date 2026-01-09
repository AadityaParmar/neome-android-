package com.neome.core.common.serializer.api.app.cli.msg

import com.neome.api.app.cli.msg.MsgNeoScriptGet
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class MsgNeoScriptGetData(
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val displayDateFormat: String,
    @Serializable(with = SysIdSer::class) override val metaId: SysId? = null,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey
) : MsgNeoScriptGet
