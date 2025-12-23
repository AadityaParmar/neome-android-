// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioMapOfOption
import com.neome.api.meta.base.dto.StudioMapOfOptionPermission

open class StudioFieldSetOfText : StudioFieldEditable()
{
  var defaultValue: Array<String>? = null
  var defaultValueFieldId: MetaIdField? = null
  var optionPermissionMap: StudioMapOfOptionPermission? = null
  var pluginApi: StudioDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var pluginInputMappingVarId: MetaIdVar? = null
  var showAs: EnumDefnThemePickMultiVariant? = null
  var source: StudioMapOfOption? = null
  var sourceFieldId: MetaIdField? = null
  var sourceVarId: MetaIdVar? = null
}