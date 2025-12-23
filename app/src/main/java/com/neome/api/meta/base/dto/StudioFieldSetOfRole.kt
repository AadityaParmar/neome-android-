// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldSetOfRole : StudioFieldEditable()
{
  var defaultRoleFieldId: MetaIdField? = null
  var defaultRoleIdSet: Array<MetaIdRole>? = null
  var showAs: EnumDefnThemePickMultiVariant? = null
}