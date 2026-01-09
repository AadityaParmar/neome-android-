package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.dto.DefnBuildDate
import kotlinx.serialization.Serializable


@Serializable
data class DefnBuildDateData(
    override val customValue: String? = null,
    override val value: EnumDefnDate? = null
) : DefnBuildDate
