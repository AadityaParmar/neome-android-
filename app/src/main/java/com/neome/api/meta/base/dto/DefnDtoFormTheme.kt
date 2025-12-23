// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeButtonSize
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFieldMargin
import com.neome.api.meta.base.Types.EnumDefnThemeFieldSize
import com.neome.api.meta.base.Types.EnumDefnThemeFieldVariant
import com.neome.api.meta.base.Types.EnumDefnThemeFormVariant

open class DefnDtoFormTheme {
    var buttonSize: EnumDefnThemeButtonSize? = null
    var buttonVariant: EnumDefnThemeButtonVariant? = null
    var colSpacing: Number? = null
    var fieldMargin: EnumDefnThemeFieldMargin? = null
    var fieldSize: EnumDefnThemeFieldSize? = null
    var fieldVariant: EnumDefnThemeFieldVariant? = null
    var formVariant: EnumDefnThemeFormVariant? = null
    var rowSpacing: Number? = null
}
