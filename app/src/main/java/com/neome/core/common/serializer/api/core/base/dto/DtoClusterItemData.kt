package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoClusterItem
import kotlinx.serialization.Serializable


@Serializable
data class DtoClusterItemData(
    override val description: String? = null,
    override val icon: String? = null,
    override val id: String? = null,
    override val label: String? = null
) : DtoClusterItem
