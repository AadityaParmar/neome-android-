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
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoLayoutFormContentItem : StudioBase() {
    var borderColorVarId: MetaIdVar? = null
    var borderPositionSet: Array<EnumDefnShowBorderKind>? = null
    var fieldIdSet: Array<MetaIdField>? = null
    var formLayoutIdSet: Array<MetaIdLayoutForm>? = null
    var gridLayoutIdSet: Array<MetaIdLayoutGrid>? = null
    var gridSwitcherSet: Array<MetaIdGrid>? = null
    var paddingPositionSet: Array<EnumDefnShowBorderKind>? = null
    var paddingSize: EnumDefnThemeDividerKind? = null
}
