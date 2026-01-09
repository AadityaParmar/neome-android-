package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioForm
import com.neome.api.meta.base.dto.StudioFormMap
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFormMapData(
    override val keys: Array<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm>,
    override val map: Map<@Serializable(with = MetaIdFormSer::class) Types.MetaIdForm, StudioForm>
) : StudioFormMap
