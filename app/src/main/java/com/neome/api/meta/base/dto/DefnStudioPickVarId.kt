// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnStudioPickVarId : DefnFieldEditable
{
  val excludeVarIdSet: Array<MetaIdVar>?
  val filterOptionSet: Array<String>?
  val formId: MetaIdForm?
  val showAsEdit: Boolean?
  val varKind: EnumStudioVarKind?
  val varKindSet: Array<EnumStudioVarKind>?
}