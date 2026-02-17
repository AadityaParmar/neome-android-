package com.neome.core.common.serializer.api.ent.entDrawer.sig

import com.neome.api.ent.base.dto.DtoPluginAuthMap
import com.neome.api.ent.entDrawer.sig.SigPluginAuthMapGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoPluginAuthMapData
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigPluginAuthMapGetData(
    override val authMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoPluginAuthMapData>
) : SigPluginAuthMapGet
