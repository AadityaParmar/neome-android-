// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldPickTree : StudioFieldEditable()
{
  var defaultOptionFieldId: MetaIdField? = null
  var defaultOptionId: String? = null
  var forceLeafSelection: Boolean? = null
  var includeAllChildrenInReport: Boolean? = null
  var pluginApi: StudioDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var pluginInputMappingVarId: MetaIdVar? = null
  var sourceVarId: MetaIdVar? = null
}