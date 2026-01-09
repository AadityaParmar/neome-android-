package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLayoutUserKind
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutUser
import com.neome.core.common.serializer.sysId.MetaIdLayoutUserSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutUserData(
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser>? = null,
    override val excludeRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val includeRoleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val kind: EnumDefnLayoutUserKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutUserSer::class) override val metaId: Types.MetaIdLayoutUser,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val showMyAssistantsOnly: Boolean? = null
) : StudioDtoLayoutUser
