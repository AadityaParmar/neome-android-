// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnThemeDirection
import com.neome.api.meta.base.Types.EnumDefnThemeSectionVariant
import com.neome.api.meta.base.dto.FieldDtoSectionLayout
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

open class DefnSection : DefnComp()
{
  var actionPermissionMap: DefnStudioMapOfActionPermission? = null
  var fieldIdSet: Array<MetaIdField>? = null
  var fieldSpanMap: Map<MetaIdField, Number>? = null
  var flexGrow: Boolean? = null
  var justifyContent: EnumDefnPlacement? = null
  lateinit var metaId: MetaIdSection
  var overflowHidden: Boolean? = null
  var propertyEditorLabel: String? = null
  var reportLayout: FieldDtoSectionLayout? = null
  var sectionDirection: EnumDefnThemeDirection? = null
  var sectionVariant: EnumDefnThemeSectionVariant? = null
}