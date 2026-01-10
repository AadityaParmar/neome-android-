package com.neome.core.common.serializer.api.core.cluster.sig

import com.neome.api.core.base.dto.DtoClusterItem
import com.neome.api.core.cluster.sig.SigClusterItemList
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.core.base.dto.DtoClusterItemData
import kotlinx.serialization.Serializable


@Serializable
data class SigClusterItemListData(
    override val clusterItemList: List<DtoClusterItemData>? = null
) : SigClusterItemList
