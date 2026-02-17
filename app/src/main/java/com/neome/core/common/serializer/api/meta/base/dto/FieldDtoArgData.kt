package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.SysIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoArgData(
    override val valueBoolean: Boolean? = null,
    override val valueDate: String? = null,
    override val valueDouble: Double? = null,
    @Serializable(with = MetaIdFieldSer::class) override val valueFieldId: Types.MetaIdField? = null,
    override val valueLong: Long? = null,
    @Serializable(with = SysIdSer::class) override val valueSysId: SysId? = null,
    override val valueSysIdArray: List<@Serializable(with = SysIdSer::class) SysId>? = null,
    override val valueSysIdSet: Set<@Serializable(with = SysIdSer::class) SysId>? = null,
    override val valueText: String? = null,
    override val valueTextArray: List<String>? = null
) : FieldDtoArg
