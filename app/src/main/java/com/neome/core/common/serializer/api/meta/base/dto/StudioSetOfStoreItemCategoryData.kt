package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfStoreItemCategory
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfStoreItemCategoryData(
    override val valueSet: Array<EnumStoreLabel>
) : StudioSetOfStoreItemCategory
