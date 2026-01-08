// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioMapOfOption
import com.neome.api.meta.base.dto.StudioMapOfOptionPermission

interface StudioFieldPickText : StudioFieldEditable
{
  val defaultOptionFieldId: MetaIdField?
  val defaultOptionId: String?
  val optionPermissionMap: StudioMapOfOptionPermission?
  val pluginApi: StudioDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val pluginInputMappingVarId: MetaIdVar?
  val showAs: EnumDefnThemePickVariant?
  val source: StudioMapOfOption?
  val sourceFieldId: MetaIdField?
  val sourceVarId: MetaIdVar?
}