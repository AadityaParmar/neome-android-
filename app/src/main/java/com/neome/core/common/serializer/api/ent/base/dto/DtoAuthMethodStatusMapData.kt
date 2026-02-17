package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAuthMethodStatusMap
import com.neome.api.ent.base.dto.DtoMethodStatus
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.ent.base.dto.DtoMethodStatusData
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAuthMethodStatusMapData(
    override val isSingleton: Boolean,
    override val map: Map<@Serializable(with = MetaIdAuthMethodSer::class) Types.MetaIdAuthMethod, DtoMethodStatusData>
) : DtoAuthMethodStatusMap
