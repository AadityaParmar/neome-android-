package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfCondition
import com.neome.api.meta.base.dto.StudioVarValueCondition
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueConditionData(
    @Serializable(with = MetaIdFormSer::class) override val inputFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val inputPluginId: Types.MetaIdPlugin? = null,
    override val node: StudioMapOfCondition? = null,
    @Serializable(with = MetaIdFormSer::class) override val sourceFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdGridSer::class) override val sourceGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdPluginSer::class) override val sourcePluginId: Types.MetaIdPlugin? = null
) : StudioVarValueCondition
