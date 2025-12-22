// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

class DefnSection : DefnComp() {
    var actionPermissionMap: DefnStudioMapOfActionPermission? = null
    var fieldIdSet: MetaIdField[]? = null
    var fieldSpanMap: Record<MetaIdField, number>? = null
    var flexGrow: boolean? = null
    var justifyContent: EnumDefnPlacement? = null
    val metaId: MetaIdSection
    var overflowHidden: boolean? = null
    var propertyEditorLabel: string? = null
    var reportLayout: FieldDtoSectionLayout? = null
    var sectionDirection: EnumDefnThemeDirection? = null
    var sectionVariant: EnumDefnThemeSectionVariant? = null
}
