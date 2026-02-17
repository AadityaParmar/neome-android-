package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.StudioDtoArgValue
import com.neome.api.meta.base.dto.StudioDtoArgValueDerived
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueDerivedData(
    @Serializable(with = MetaIdFieldSer::class) override val derivedFieldId: Types.MetaIdField,
    override val derivedFieldType: EnumDefnCompType? = null,
    override val valueBoolean: Boolean? = null,
    override val valueDate: String? = null,
    override val valueDouble: Double? = null,
    override val valueLong: Long? = null,
    override val valueOptionId: String? = null,
    override val valueText: String? = null
) : StudioDtoArgValueDerived
