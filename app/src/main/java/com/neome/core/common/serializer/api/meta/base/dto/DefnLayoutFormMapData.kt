package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnLayoutForm
import com.neome.api.meta.base.dto.DefnLayoutFormMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutFormData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormMapData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val asideDefaultLayoutId: Types.MetaIdLayoutForm? = null,
    override val keys: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>,
    override val map: Map<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm, DefnLayoutFormData>,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileDefaultLayoutId: Types.MetaIdLayoutForm? = null
) : DefnLayoutFormMap
