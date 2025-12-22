// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class DefnDtoLayoutFormContentItem {
    var borderColorVar: DefnDtoColor? = null
    var borderPositionSet: EnumDefnShowBorderKind[]? = null
    var fieldIdSet: MetaIdField[]? = null
    var formLayoutIdSet: MetaIdLayoutForm[]? = null
    var gridLayoutIdSet: MetaIdLayoutGrid[]? = null
    var paddingPositionSet: EnumDefnShowBorderKind[]? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
    var showGridSwitcher: MetaIdGrid[]? = null
}
