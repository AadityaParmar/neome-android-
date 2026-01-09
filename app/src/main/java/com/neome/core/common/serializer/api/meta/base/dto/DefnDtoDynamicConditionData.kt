package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDynamicOperator
import com.neome.api.meta.base.dto.DefnDtoDynamicCondition
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoDynamicConditionData(
    @Serializable(with = MetaIdFieldSer::class) override val lhs: Types.MetaIdField,
    override val operator: EnumDefnDynamicOperator,
    override val rhs: FieldDtoArg? = null
) : DefnDtoDynamicCondition
