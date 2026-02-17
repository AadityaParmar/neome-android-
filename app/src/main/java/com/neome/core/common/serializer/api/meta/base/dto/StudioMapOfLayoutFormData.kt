package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindFormRenderingMode
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutForm
import com.neome.api.meta.base.dto.StudioMapOfLayoutForm
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutFormData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfLayoutFormData(
    @Serializable(with = MetaIdLayoutFormSer::class) override val asideDefaultLayoutId: Types.MetaIdLayoutForm? = null,
    override val keys: List<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm>,
    override val map: Map<@Serializable(with = MetaIdLayoutFormSer::class) Types.MetaIdLayoutForm, StudioDtoLayoutFormData>,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileDefaultLayoutId: Types.MetaIdLayoutForm? = null,
    override val renderingModeKind: EnumDefnKindFormRenderingMode? = null
) : StudioMapOfLayoutForm
