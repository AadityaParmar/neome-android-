package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.ent.base.dto.SpreadsheetFilterValue
import com.neome.core.common.serializer.api.ent.base.dto.SpreadsheetFilterCompositeData
import com.neome.core.common.serializer.api.ent.base.dto.SpreadsheetFilterValueData
import kotlinx.serialization.Serializable


@Serializable
data class SpreadsheetFilterCompositeData(
    override val andOr: Boolean? = null,
    override val filter: SpreadsheetFilterValueData? = null,
    override val filterList: List<SpreadsheetFilterCompositeData>? = null
) : SpreadsheetFilterComposite
