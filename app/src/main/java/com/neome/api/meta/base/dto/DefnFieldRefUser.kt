// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnFieldRefUser : DefnFieldEditable
{
  val copyFieldVarMap: Map<MetaIdField, MetaIdVar>?
  val dataSourceVarId: MetaIdVar?
  val defaultValue: MetaIdRole?
  val defaultValueFieldId: MetaIdField?
  val pluginApi: DefnDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val roleIdDataSource: Array<MetaIdRole>?
}