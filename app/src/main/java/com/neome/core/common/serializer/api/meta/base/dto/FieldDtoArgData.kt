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
    override val valueDouble: Long? = null,
    @Serializable(with = MetaIdFieldSer::class) override val valueFieldId: Types.MetaIdField? = null,
    override val valueLong: Long? = null,
    @Serializable(with = SysIdSer::class) override val valueSysId: SysId? = null,
    override val valueSysIdArray: Array<@Serializable(with = SysIdSer::class) SysId>? = null,
    override val valueSysIdSet: Array<@Serializable(with = SysIdSer::class) SysId>? = null,
    override val valueText: String? = null,
    override val valueTextArray: Array<String>? = null
) : FieldDtoArg
