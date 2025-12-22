// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeColor
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind

class DefnFieldDivider : DefnField() {
    var color: DefnDtoColor? = null
    var colorVar: EnumDefnThemeColor? = null
    var dividerKind: EnumDefnThemeDividerKind? = null
    var dividerKindVar: EnumDefnThemeDividerKind? = null
    var sectionDirection: EnumDefnThemeDirection? = null
}
