package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnLayoutFormWatermark
import com.neome.api.meta.base.dto.FieldDtoImage
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormWatermarkData(
    override val bgImage: FieldDtoImage? = null,
    override val bgImageHorizontalPosition: EnumDefnContentAlignment? = null,
    override val bgImageVar: FieldDtoImage? = null,
    override val bgImageVerticalPosition: EnumDefnContentAlignment? = null,
    override val textOpacityVar: Long? = null,
    override val textPatternVar: DefnDtoText? = null,
    override val textPositionVar: EnumDefnPlacement? = null,
    override val textSizeVar: EnumDefnTextSize? = null
) : DefnLayoutFormWatermark
