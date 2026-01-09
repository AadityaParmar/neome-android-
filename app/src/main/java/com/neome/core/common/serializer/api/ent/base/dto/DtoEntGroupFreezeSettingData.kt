package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSetting
import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntGroupFreezeSettingData(
    override val freeze: Boolean? = null,
    override val freezeAvatarKind: EnumDefnFreezeAvatarKind? = null,
    override val freezeSortName: String? = null
) : DtoEntGroupFreezeSetting
