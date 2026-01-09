package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutUser
import com.neome.api.meta.base.dto.StudioMapOfLayoutUser
import com.neome.core.common.serializer.sysId.MetaIdLayoutUserSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfLayoutUserData(
    override val keys: Array<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser>,
    override val map: Map<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser, StudioDtoLayoutUser>,
    @Serializable(with = MetaIdLayoutUserSer::class) override val mobileDefaultLayoutId: Types.MetaIdLayoutUser? = null,
    @Serializable(with = MetaIdLayoutUserSer::class) override val webDefaultLayoutId: Types.MetaIdLayoutUser? = null
) : StudioMapOfLayoutUser
