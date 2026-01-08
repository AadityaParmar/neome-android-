// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DefnStudioVarIdParagraphEditor : DefnField
{
  val argBinderFilterVarKindSet: Array<EnumStudioVarKind>?
  val argBinderFormId: MetaIdForm
  val compositeIdSet: Array<MetaIdComposite>?
  val excludeFieldIdSet: Array<MetaIdField>?
  val filterVarKindSet: Array<EnumStudioVarKind>?
  val pluginId: MetaIdPlugin?
  val required: Boolean?
  val showAsEdit: Boolean?
}