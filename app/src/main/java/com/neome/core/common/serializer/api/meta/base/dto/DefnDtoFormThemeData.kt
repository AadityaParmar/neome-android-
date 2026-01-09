package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeButtonSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFieldMargin
import com.neome.api.meta.base.Types.EnumDefnThemeFieldSize
import com.neome.api.meta.base.Types.EnumDefnThemeFieldVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFormVariant
import com.neome.api.meta.base.dto.DefnDtoFormTheme
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoFormThemeData(
    override val buttonSize: EnumDefnThemeButtonSize? = null,
    override val buttonVariant: EnumDefnThemeButtonVariant? = null,
    override val colSpacing: Long? = null,
    override val fieldMargin: EnumDefnThemeFieldMargin? = null,
    override val fieldSize: EnumDefnThemeFieldSize? = null,
    override val fieldVariant: EnumDefnThemeFieldVariant? = null,
    override val formVariant: EnumDefnThemeFormVariant? = null,
    override val rowSpacing: Long? = null
) : DefnDtoFormTheme
