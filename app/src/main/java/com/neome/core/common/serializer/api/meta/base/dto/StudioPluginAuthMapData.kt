package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginAuthBase
import com.neome.api.meta.base.dto.StudioPluginAuthMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginAuthBaseData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginAuthMapData(
    @Serializable(with = MetaIdAuthMethodSer::class) override val defaultAuthMethodId: Types.MetaIdAuthMethod? = null,
    override val keys: List<@Serializable(with = MetaIdAuthMethodSer::class) Types.MetaIdAuthMethod>,
    override val map: Map<@Serializable(with = MetaIdAuthMethodSer::class) Types.MetaIdAuthMethod, StudioPluginAuthBaseData>
) : StudioPluginAuthMap
