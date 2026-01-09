package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnLayoutUser
import com.neome.api.meta.base.dto.DefnLayoutUserMap
import com.neome.core.common.serializer.sysId.MetaIdLayoutUserSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutUserMapData(
    override val keys: Array<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser>,
    override val map: Map<@Serializable(with = MetaIdLayoutUserSer::class) Types.MetaIdLayoutUser, DefnLayoutUser>,
    @Serializable(with = MetaIdLayoutUserSer::class) override val mobileDefaultLayoutId: Types.MetaIdLayoutUser? = null,
    @Serializable(with = MetaIdLayoutUserSer::class) override val webDefaultLayoutId: Types.MetaIdLayoutUser? = null
) : DefnLayoutUserMap
