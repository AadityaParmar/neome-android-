package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoFieldFilter
import com.neome.api.ent.base.dto.DtoFieldFilterOption
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoFieldFilterData(
    override val defnFieldType: EnumDefnCompType,
    override val label: String? = null,
    @Serializable(with = MetaIdCompSer::class) override val metaIdField: Types.MetaIdComp,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val valueList: Array<DtoFieldFilterOption>? = null
) : DtoFieldFilter
