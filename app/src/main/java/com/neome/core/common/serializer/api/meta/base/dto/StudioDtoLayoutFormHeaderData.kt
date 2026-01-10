package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutFormHeader
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormHeaderData(
    override val backgroundColor: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVarSer::class) override val backgroundColorVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formLayoutId: Types.MetaIdLayoutForm? = null,
    override val headerImage: FieldDtoImageData? = null,
    override val headerImageHeight: Long? = null,
    @Serializable(with = MetaIdVarSer::class) override val headerImageVarId: Types.MetaIdVar? = null,
    override val hyperlinkVarIdSet: List<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>? = null,
    override val showEnterprise: Boolean? = null,
    override val showSeparator: Boolean? = null,
    override val textColor: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVarSer::class) override val textColorVarId: Types.MetaIdVar? = null
) : StudioDtoLayoutFormHeader
