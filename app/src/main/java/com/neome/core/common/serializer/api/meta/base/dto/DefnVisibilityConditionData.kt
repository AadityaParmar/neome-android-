package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnVisibilityOperator
import com.neome.api.meta.base.dto.DefnVisibilityCondition
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnVisibilityConditionData(
    @Serializable(with = MetaIdFieldSer::class) override val lhs: Types.MetaIdField,
    override val operator: EnumDefnVisibilityOperator,
    override val rhs: FieldDtoArg? = null
) : DefnVisibilityCondition
