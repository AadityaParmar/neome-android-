package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumFieldFilterValueType
import com.neome.api.ent.base.dto.SpreadsheetFilterValue
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import kotlinx.serialization.Serializable


@Serializable
data class SpreadsheetFilterValueData(
    @Serializable(with = MetaIdCompSer::class) override val metaIdField: Types.MetaIdComp,
    override val type: EnumFieldFilterValueType
) : SpreadsheetFilterValue
