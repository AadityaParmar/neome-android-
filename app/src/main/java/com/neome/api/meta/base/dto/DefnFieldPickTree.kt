// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPluginApi
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.FieldDtoTree
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldPickTree : DefnFieldEditable
{
  val autoPickSingleChild: Boolean?
  val defaultOptionFieldId: MetaIdField?
  val defaultOptionId: String?
  val forceLeafSelection: Boolean?
  val includeAllChildrenInReport: Boolean?
  val pluginApi: DefnDtoPluginApi?
  val pluginErrorFieldId: MetaIdField?
  val sourceVar: FieldDtoTree?
}