package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoFieldFilterOption
import kotlinx.serialization.Serializable


@Serializable
data class DtoFieldFilterOptionData(
    override val childFilters: Array<DtoFieldFilterOption>? = null,
    override val label: String,
    override val value: String
) : DtoFieldFilterOption
