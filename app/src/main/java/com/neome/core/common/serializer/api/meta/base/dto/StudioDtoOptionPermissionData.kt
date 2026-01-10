package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOptionPermission
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoOptionPermissionData(
    @Serializable(with = MetaIdRoleSer::class) override val metaId: Types.MetaIdRole,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val optionIdSet: List<String>
) : StudioDtoOptionPermission
