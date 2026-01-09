package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioValueCode
import com.neome.api.meta.base.dto.StudioValueCodeNeoQL
import com.neome.core.common.serializer.sysId.MetaIdCodeSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueCodeNeoQLData(
    @Serializable(with = MetaIdCodeSer::class) override val metaId: Types.MetaIdCode,
    override val value: String? = null
) : StudioValueCodeNeoQL
