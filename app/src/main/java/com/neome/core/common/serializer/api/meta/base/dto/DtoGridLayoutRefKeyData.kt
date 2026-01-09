package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DtoGridLayoutRefKey
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoGridLayoutRefKeyData(
    @Serializable(with = MetaIdGridSer::class) override val gridId: Types.MetaIdGrid,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutGridId: Types.MetaIdLayoutGrid
) : DtoGridLayoutRefKey
