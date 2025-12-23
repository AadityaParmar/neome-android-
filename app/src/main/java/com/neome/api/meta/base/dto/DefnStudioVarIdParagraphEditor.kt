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

open class DefnStudioVarIdParagraphEditor : DefnField()
{
  var argBinderFilterVarKindSet: Array<EnumStudioVarKind>? = null
  lateinit var argBinderFormId: MetaIdForm
  var compositeIdSet: Array<MetaIdComposite>? = null
  var excludeFieldIdSet: Array<MetaIdField>? = null
  var filterVarKindSet: Array<EnumStudioVarKind>? = null
  var pluginId: MetaIdPlugin? = null
  var required: Boolean? = null
  var showAsEdit: Boolean? = null
}