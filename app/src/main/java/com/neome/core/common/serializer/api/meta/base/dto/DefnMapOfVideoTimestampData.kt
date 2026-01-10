package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoVideoTimestamp
import com.neome.api.meta.base.dto.DefnMapOfVideoTimestamp
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoVideoTimestampData
import com.neome.core.common.serializer.sysId.MetaIdVideoTimestampSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnMapOfVideoTimestampData(
    override val keys: List<@Serializable(with = MetaIdVideoTimestampSer::class) Types.MetaIdVideoTimestamp>,
    override val map: Map<@Serializable(with = MetaIdVideoTimestampSer::class) Types.MetaIdVideoTimestamp, DefnDtoVideoTimestampData>
) : DefnMapOfVideoTimestamp
