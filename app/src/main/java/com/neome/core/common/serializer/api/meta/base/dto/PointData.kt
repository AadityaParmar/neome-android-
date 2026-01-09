package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.Point
import kotlinx.serialization.Serializable


@Serializable
data class PointData(
    override val x: Long? = null,
    override val y: Long? = null
) : Point
