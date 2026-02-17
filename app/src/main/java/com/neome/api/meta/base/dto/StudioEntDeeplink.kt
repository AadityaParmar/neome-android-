// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeeplinkConstraint
import com.neome.api.meta.base.Types.EnumDefnDeeplinkExpiry
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.EnumDefnUserProps
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

interface StudioEntDeeplink : StudioBase
{
  val creationRoles: List<MetaIdRole>?
  val description: String?
  val expiry: EnumDefnDeeplinkExpiry?
  val kind: EnumDefnKindDeeplink
  val makeUserDefaultRoles: List<MetaIdRole>?
  val metaId: MetaIdDeeplink
  val modules: StudioModuleSelection?
  val name: Symbol
  val showEnterpriseImageInLinkPreview: Boolean?
  val targetUserHandleFieldId: MetaIdField?
  val targetUserSpreadsheetId: MetaIdSpreadsheet?
  val userFieldMap: Map<EnumDefnUserProps, MetaIdField>?
  val visibilityConstraint: EnumDefnDeeplinkConstraint?
}