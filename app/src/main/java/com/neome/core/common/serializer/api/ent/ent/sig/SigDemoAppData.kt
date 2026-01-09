package com.neome.core.common.serializer.api.ent.ent.sig

import com.neome.api.ent.ent.sig.SigDemoApp
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.DemoAppIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class SigDemoAppData(
    override val app: JsonElement,
    @Serializable(with = DemoAppIdSer::class) override val demoAppId: Types.DemoAppId,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId
) : SigDemoApp
