package com.neome.core.common.serializer.api.app.cli.sig

import com.neome.api.app.cli.sig.SigNeoScriptGet
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigNeoScriptGetData(
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    @Serializable(with = SysIdSer::class) override val metaId: SysId? = null,
    override val neoScript: String? = null
) : SigNeoScriptGet
