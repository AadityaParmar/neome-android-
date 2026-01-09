package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdViewport
import com.neome.api.meta.base.dto.StudioBase
import kotlinx.serialization.Serializable


@Serializable
data class EntVdViewportData(
    override val x: Long? = null,
    override val y: Long? = null,
    override val zoom: Long? = null
) : EntVdViewport
