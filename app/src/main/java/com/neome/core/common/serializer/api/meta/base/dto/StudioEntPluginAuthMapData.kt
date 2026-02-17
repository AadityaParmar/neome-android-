package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioEntPluginAuthBase
import com.neome.api.meta.base.dto.StudioEntPluginAuthMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginAuthBaseData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginAuthMapData(
    @Serializable(with = MetaIdAuthMethodSer::class) override val defaultAuthMethodId: Types.MetaIdAuthMethod? = null,
    override val map: Map<@Serializable(with = MetaIdAuthMethodSer::class) Types.MetaIdAuthMethod, StudioEntPluginAuthBaseData>
) : StudioEntPluginAuthMap
