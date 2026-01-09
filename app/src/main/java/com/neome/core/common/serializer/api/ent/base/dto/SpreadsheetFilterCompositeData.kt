package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.ent.base.dto.SpreadsheetFilterValue
import kotlinx.serialization.Serializable


@Serializable
data class SpreadsheetFilterCompositeData(
    override val andOr: Boolean? = null,
    override val filter: SpreadsheetFilterValue? = null,
    override val filterList: Array<SpreadsheetFilterComposite>? = null
) : SpreadsheetFilterComposite
