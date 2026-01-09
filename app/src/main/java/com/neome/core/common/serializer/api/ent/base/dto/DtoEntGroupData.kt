package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroup
import com.neome.api.ent.base.dto.DtoEntGroupActionPermissionMap
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntGroupData(
    override val actionPermissionMap: DtoEntGroupActionPermissionMap,
    override val freeze: Boolean? = null,
    override val freezeAvatarKind: EnumDefnFreezeAvatarKind? = null,
    override val freezeSortName: String? = null,
    override val removeMessagePermissionSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null
) : DtoEntGroup
