package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoMethodStatus
import com.neome.api.meta.base.Types.EnumDefnPluginAuthMethod
import kotlinx.serialization.Serializable


@Serializable
data class DtoMethodStatusData(
    override val connected: Boolean,
    override val kind: EnumDefnPluginAuthMethod
) : DtoMethodStatus
