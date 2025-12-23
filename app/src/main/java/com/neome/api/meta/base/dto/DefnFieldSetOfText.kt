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

open class DefnFieldSetOfText : DefnFieldEditable()
{
  var defaultValue: Array<String>? = null
  var defaultValueFieldId: MetaIdField? = null
  var optionFieldId: MetaIdField? = null
  var optionMap: DefnStudioMapOfDtoOption? = null
  var optionPermissionMap: DefnStudioMapOfOptionPermission? = null
  var pageSize: Number? = null
  var pluginApi: DefnDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var showAs: EnumDefnThemePickMultiVariant? = null
}