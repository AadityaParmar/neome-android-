package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutFormWatermark
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutFormWatermarkData(
    override val bgImage: FieldDtoImage? = null,
    override val bgImageHorizontalPosition: EnumDefnContentAlignment? = null,
    @Serializable(with = MetaIdVarSer::class) override val bgImageVarId: Types.MetaIdVar? = null,
    override val bgImageVerticalPosition: EnumDefnContentAlignment? = null,
    @Serializable(with = MetaIdVarSer::class) override val textOpacityVarId: Types.MetaIdVar? = null,
    override val textPatternVarId: StudioValueVarIdText? = null,
    @Serializable(with = MetaIdVarSer::class) override val textPositionVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdVarSer::class) override val textSizeVarId: Types.MetaIdVar? = null
) : StudioDtoLayoutFormWatermark
