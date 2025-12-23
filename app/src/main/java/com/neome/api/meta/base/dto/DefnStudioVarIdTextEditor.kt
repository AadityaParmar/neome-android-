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

open class DefnStudioVarIdTextEditor : DefnField()
{
  var argBinderFilterVarKindSet: Array<EnumStudioVarKind>? = null
  var argBinderFormId: MetaIdForm? = null
  var excludeFieldIdSet: Array<MetaIdField>? = null
  var filterContextOptionSet: Array<String>? = null
  var filterKindSet: Array<EnumDefnArgBinder>? = null
  var filterVarKindSet: Array<EnumStudioVarKind>? = null
  var inputFormId: MetaIdForm? = null
  var pluginConfigFormId: MetaIdForm? = null
  var pluginId: MetaIdPlugin? = null
  var showAsEdit: Boolean? = null
}