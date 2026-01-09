package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoPartition
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdPartitionSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPartitionData(
    @Serializable(with = MetaIdFieldSer::class) override val assignPartitionFieldId: Types.MetaIdField,
    override val partition: String,
    @Serializable(with = MetaIdPartitionSer::class) override val partitionId: Types.MetaIdPartition
) : DtoPartition
