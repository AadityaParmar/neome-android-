// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoLayoutLocmapPin : StudioBase() {
    var avatar: FieldDtoImage? = null
    var avatarFieldId: MetaIdField? = null
    var avatarVarId: MetaIdVar? = null
    var color: StudioDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVarId: MetaIdVar? = null
    var label: string? = null
    var labelFieldId: MetaIdField? = null
    var labelVarId: StudioValueVarIdText? = null
    var shape: EnumDefnMapPinShape? = null
    var shapeFieldId: MetaIdField? = null
    var shapeVarId: MetaIdVar? = null
    var toolTip: string? = null
    var toolTipFieldId: MetaIdField? = null
    var toolTipVarId: StudioValueVarIdParagraph? = null
}
