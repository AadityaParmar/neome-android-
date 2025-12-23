// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldRefUser : StudioFieldEditable()
{
  var copyFieldVarMap: Map<MetaIdField, MetaIdVar>? = null
  var dataSourceVarId: MetaIdVar? = null
  var defaultValue: MetaIdRole? = null
  var defaultValueFieldId: MetaIdField? = null
  var pluginApi: StudioDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var pluginInputMappingVarId: MetaIdVar? = null
  var roleIdDataSource: Array<MetaIdRole>? = null
}