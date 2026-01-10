// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

interface DefnSection : DefnComp {
    val actionPermissionMap: DefnStudioMapOfActionPermission?
    val fieldIdSet: List<MetaIdField>?
    val fieldSpanMap: Map<MetaIdField, Long>?
    val flexGrow: Boolean?
    val justifyContent: EnumDefnPlacement?
    val metaId: MetaIdSection
    val overflowHidden: Boolean?
    val propertyEditorLabel: String?
    val reportLayout: FieldDtoSectionLayout?
    val sectionDirection: EnumDefnThemeDirection?
    val sectionVariant: EnumDefnThemeSectionVariant?
}
