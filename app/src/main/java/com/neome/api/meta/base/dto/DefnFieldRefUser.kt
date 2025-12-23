// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnFieldEditable
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

open class DefnFieldRefUser : DefnFieldEditable()
{
  var copyFieldVarMap: Map<MetaIdField, MetaIdVar>? = null
  var dataSourceVarId: MetaIdVar? = null
  var defaultValue: MetaIdRole? = null
  var defaultValueFieldId: MetaIdField? = null
  var pluginApi: DefnDtoPluginApi? = null
  var pluginErrorFieldId: MetaIdField? = null
  var roleIdDataSource: Array<MetaIdRole>? = null
}