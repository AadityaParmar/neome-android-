// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.dto.DefnStudioMapOfOptionPermission
import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldSetOfText : DefnFieldEditable
{
  val defaultValue: Array<String>?
  val defaultValueFieldId: MetaIdField?
  val optionFieldId: MetaIdField?
  val optionMap: DefnStudioMapOfDtoOption?
  val optionPermissionMap: DefnStudioMapOfOptionPermission?
  val pageSize: Long?
  val pluginApi: DefnDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val showAs: EnumDefnThemePickMultiVariant?
}