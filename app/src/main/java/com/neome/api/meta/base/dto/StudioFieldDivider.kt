// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldDivider : StudioField() {
    var color: StudioDtoColor? = null
    var colorVarId: MetaIdVar? = null
    var dividerKind: EnumDefnThemeDividerKind? = null
    var dividerKindVarId: MetaIdVar? = null
}
