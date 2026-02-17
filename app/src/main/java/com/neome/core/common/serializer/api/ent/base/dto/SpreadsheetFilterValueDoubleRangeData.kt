package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumFieldFilterValueType
import com.neome.api.ent.base.dto.SpreadsheetFilterValue
import com.neome.api.ent.base.dto.SpreadsheetFilterValueDoubleRange
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import kotlinx.serialization.Serializable


@Serializable
data class SpreadsheetFilterValueDoubleRangeData(
    @Serializable(with = MetaIdCompSer::class) override val metaIdField: Types.MetaIdComp,
    override val type: EnumFieldFilterValueType,
    override val max: Double? = null,
    override val min: Double? = null
) : SpreadsheetFilterValueDoubleRange
