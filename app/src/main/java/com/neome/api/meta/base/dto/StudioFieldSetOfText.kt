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

interface StudioFieldSetOfText : StudioFieldEditable
{
  val defaultValue: Array<String>?
  val defaultValueFieldId: MetaIdField?
  val optionPermissionMap: StudioMapOfOptionPermission?
  val pluginApi: StudioDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val pluginInputMappingVarId: MetaIdVar?
  val showAs: EnumDefnThemePickMultiVariant?
  val source: StudioMapOfOption?
  val sourceFieldId: MetaIdField?
  val sourceVarId: MetaIdVar?
}