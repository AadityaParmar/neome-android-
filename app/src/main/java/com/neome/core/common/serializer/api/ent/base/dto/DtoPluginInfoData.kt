package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodInfo
import com.neome.api.ent.base.dto.DtoPluginInfo
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.base.dto.DtoAuthMethodInfoData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPluginInfoData(
    override val authMethodMap: Map<@Serializable(with = MetaIdAuthMethodSer::class) Types.MetaIdAuthMethod, DtoAuthMethodInfoData>? = null,
    override val name: String? = null
) : DtoPluginInfo
