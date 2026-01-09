package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioStoreItemDetail
import com.neome.core.common.serializer.sysId.StoreItemIdSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioStoreItemDetailData(
    @Serializable(with = StoreItemIdSer::class) override val storeItemId: Types.StoreItemId,
    override val storeName: String
) : StudioStoreItemDetail
