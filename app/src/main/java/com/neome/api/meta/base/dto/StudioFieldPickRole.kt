// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldPickRole : StudioFieldEditable
{
  val defaultRoleFieldId: MetaIdField?
  val defaultRoleId: MetaIdRole?
  val showAs: EnumDefnThemePickVariant?
}