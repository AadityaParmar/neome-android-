package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoVideoTimestamp
import com.neome.core.common.serializer.sysId.MetaIdVideoTimestampSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoVideoTimestampData(
    @Serializable(with = MetaIdVideoTimestampSer::class) override val metaId: Types.MetaIdVideoTimestamp? = null,
    override val startTimeMinutes: Long? = null,
    override val startTimeSeconds: Long? = null,
    override val style: String? = null,
    override val title: String? = null
) : DefnDtoVideoTimestamp
