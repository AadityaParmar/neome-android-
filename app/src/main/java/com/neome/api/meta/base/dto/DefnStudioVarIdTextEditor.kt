// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DefnStudioVarIdTextEditor : DefnField
{
  val argBinderFilterVarKindSet: Array<EnumStudioVarKind>?
  val argBinderFormId: MetaIdForm?
  val excludeFieldIdSet: Array<MetaIdField>?
  val filterContextOptionSet: Array<String>?
  val filterKindSet: Array<EnumDefnArgBinder>?
  val filterVarKindSet: Array<EnumStudioVarKind>?
  val inputFormId: MetaIdForm?
  val pluginConfigFormId: MetaIdForm?
  val pluginId: MetaIdPlugin?
  val showAsEdit: Boolean?
}