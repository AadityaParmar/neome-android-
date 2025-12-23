// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

open class DefnComp
{
  var disabled: Boolean? = null
  var disabledFieldId: MetaIdField? = null
  var disabledRoleIdSet: Array<MetaIdRole>? = null
  var disabledVar: Boolean? = null
  var hidden: Boolean? = null
  var hideDirtyIndicator: Boolean? = null
  var invisible: Boolean? = null
  var label: String? = null
  var maxWidth: Number? = null
  lateinit var name: Symbol
  var pb: Number? = null
  var permissionMatrix: DefnDtoPermissionMatrix? = null
  var pl: Number? = null
  var pr: Number? = null
  var pt: Number? = null
  var readOnly: Boolean? = null
  lateinit var type: EnumDefnCompType
}