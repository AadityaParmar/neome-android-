package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPartition
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdPartitionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoPartitionData(
    @Serializable(with = MetaIdFieldSer::class) override val assignPartitionFieldId: Types.MetaIdField,
    override val formula: StudioValueCodeJavascript,
    @Serializable(with = MetaIdPartitionSer::class) override val metaId: Types.MetaIdPartition,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : StudioDtoPartition
