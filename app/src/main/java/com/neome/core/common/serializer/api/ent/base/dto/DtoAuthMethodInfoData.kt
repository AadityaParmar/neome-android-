package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodInfo
import com.neome.api.meta.base.Types.EnumDefnPluginAuthMethod
import kotlinx.serialization.Serializable


@Serializable
data class DtoAuthMethodInfoData(
    override val method: EnumDefnPluginAuthMethod? = null,
    override val name: String? = null
) : DtoAuthMethodInfo
