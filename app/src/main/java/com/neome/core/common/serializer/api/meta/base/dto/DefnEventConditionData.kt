package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnEventOperator
import com.neome.api.meta.base.dto.DefnEventCondition
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoArgData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnEventConditionData(
    @Serializable(with = MetaIdFieldSer::class) override val lhs: Types.MetaIdField,
    override val operator: EnumDefnEventOperator,
    override val rhs: FieldDtoArgData? = null
) : DefnEventCondition
