package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntRole
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntRoleData(
    override val description: String? = null,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdRoleSer::class) override val roleId: Types.MetaIdRole
) : DtoEntRole
