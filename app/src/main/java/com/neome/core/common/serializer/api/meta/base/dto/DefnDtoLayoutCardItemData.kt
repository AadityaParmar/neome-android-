package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLine
import com.neome.api.meta.base.dto.DefnDtoMedia
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutCardItemData(
    override val fifthLine: DefnDtoLayoutCardItemLine? = null,
    override val firstLine: DefnDtoLayoutCardItemLine? = null,
    override val fourthLine: DefnDtoLayoutCardItemLine? = null,
    override val imageBackgroundColor: DefnDtoColor? = null,
    override val imageCornerVar: EnumDefnThemeImageCorner? = null,
    override val imageHeight: Long? = null,
    override val imageHeightVar: Long? = null,
    override val imageRenderingMode: EnumDefnThemeImageRenderingMode? = null,
    override val imageWidth: Long? = null,
    override val imageWidthVar: Long? = null,
    override val mediaFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val mediaVarSet: Array<DefnDtoMedia>? = null,
    override val secondLine: DefnDtoLayoutCardItemLine? = null,
    override val thirdLine: DefnDtoLayoutCardItemLine? = null
) : DefnDtoLayoutCardItem
