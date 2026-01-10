package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnConditionOperator
import com.neome.api.meta.base.dto.DefnDtoConditionStatement
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoArgData
import com.neome.core.common.serializer.sysId.MetaIdConditionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoConditionStatementData(
    override val lhs: FieldDtoArgData,
    @Serializable(with = MetaIdConditionSer::class) override val metaId: Types.MetaIdCondition,
    override val operator: EnumDefnConditionOperator? = null,
    override val rhs: FieldDtoArgData? = null
) : DefnDtoConditionStatement
