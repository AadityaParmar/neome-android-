package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPartition
import com.neome.api.meta.base.dto.StudioMapOfPartition
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoPartitionData
import com.neome.core.common.serializer.sysId.MetaIdPartitionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfPartitionData(
    override val keys: List<@Serializable(with = MetaIdPartitionSer::class) Types.MetaIdPartition>? = null,
    override val map: Map<@Serializable(with = MetaIdPartitionSer::class) Types.MetaIdPartition, StudioDtoPartitionData>
) : StudioMapOfPartition
