package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.NeatPath
import com.neome.api.meta.base.dto.TranslatePath
import com.neome.core.common.serializer.api.meta.base.dto.NeatPathData
import kotlinx.serialization.Serializable


@Serializable
data class TranslatePathData(
    override val neatPath: NeatPathData? = null,
    override val searchPath: String? = null
) : TranslatePath
