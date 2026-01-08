// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutUserKind
import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

interface StudioDtoLayoutUser : StudioBase
{
  val allowToSwitchLayoutIdSet: Array<MetaIdLayoutUser>?
  val excludeRoleIdSet: Array<MetaIdRole>?
  val includeRoleIdSet: Array<MetaIdRole>?
  val kind: EnumDefnLayoutUserKind
  val label: String?
  val metaId: MetaIdLayoutUser
  val name: Symbol
  val showMyAssistantsOnly: Boolean?
}