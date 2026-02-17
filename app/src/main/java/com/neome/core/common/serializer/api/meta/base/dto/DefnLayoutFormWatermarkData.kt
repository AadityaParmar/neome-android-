package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnLayoutFormWatermark
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutFormWatermarkData(
    override val bgImage: FieldDtoImageData? = null,
    override val bgImageHorizontalPosition: EnumDefnContentAlignment? = null,
    override val bgImageVar: FieldDtoImageData? = null,
    override val bgImageVerticalPosition: EnumDefnContentAlignment? = null,
    override val textOpacityVar: Double? = null,
    override val textPatternVar: DefnDtoTextData? = null,
    override val textPositionVar: EnumDefnPlacement? = null,
    override val textSizeVar: EnumDefnTextSize? = null
) : DefnLayoutFormWatermark
