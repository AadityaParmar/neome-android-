package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioStoreItemDetail
import com.neome.api.meta.base.dto.StudioStoreItemDetailMap
import com.neome.core.common.serializer.sysId.StoreItemIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioStoreItemDetailMapData(
    override val keys: Array<@Serializable(with = StoreItemIdSer::class) Types.StoreItemId>,
    override val map: Map<@Serializable(with = StoreItemIdSer::class) Types.StoreItemId, StudioStoreItemDetail>
) : StudioStoreItemDetailMap
