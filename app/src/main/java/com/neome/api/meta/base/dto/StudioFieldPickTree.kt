// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldPickTree : StudioFieldEditable
{
  val defaultOptionFieldId: MetaIdField?
  val defaultOptionId: String?
  val forceLeafSelection: Boolean?
  val includeAllChildrenInReport: Boolean?
  val pluginApi: StudioDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val pluginInputMappingVarId: MetaIdVar?
  val sourceVarId: MetaIdVar?
}