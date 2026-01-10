package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfUserCondition
import com.neome.api.meta.base.dto.StudioVarValueSetOfUser
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfUserConditionData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueSetOfUserData(
    override val node: StudioMapOfUserConditionData? = null,
    @Serializable(with = MetaIdFormSer::class) override val sourceFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val sourcePluginId: Types.MetaIdPlugin? = null
) : StudioVarValueSetOfUser
