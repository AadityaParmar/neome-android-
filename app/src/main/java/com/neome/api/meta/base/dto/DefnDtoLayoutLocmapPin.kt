// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.Types.MetaIdField

class DefnDtoLayoutLocmapPin {
    var avatar: FieldDtoImage? = null
    var avatarFieldId: MetaIdField? = null
    var avatarVar: FieldDtoImage? = null
    var color: DefnDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVar: DefnDtoColor? = null
    var label: string? = null
    var labelFieldId: MetaIdField? = null
    var labelVar: DefnDtoText? = null
    var shape: EnumDefnMapPinShape? = null
    var shapeFieldId: MetaIdField? = null
    var shapeVar: EnumDefnMapPinShape? = null
    var toolTip: string? = null
    var toolTipFieldId: MetaIdField? = null
    var toolTipVar: DefnDtoParagraph? = null
}
