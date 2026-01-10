package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumNeatPathCaption
import com.neome.api.meta.base.dto.NeatPath
import kotlinx.serialization.Serializable


@Serializable
data class NeatPathData(
    override val caption: EnumNeatPathCaption? = null,
    override val primary: List<String>? = null,
    override val secondary: String? = null
) : NeatPath
