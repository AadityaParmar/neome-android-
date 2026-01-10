package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioFieldMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioFieldData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFieldMapData(
    override val keys: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>,
    override val map: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, StudioFieldData>
) : StudioFieldMap
