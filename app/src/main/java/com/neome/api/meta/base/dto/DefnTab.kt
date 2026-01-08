// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdTab

interface DefnTab : DefnComp
{
  val metaId: MetaIdTab
  val showAsTree: Boolean?
  val showDivider: Boolean?
  val showSingleTab: Boolean?
  val tabIdSet: Array<MetaIdComposite>?
  val tabVariant: EnumDefnThemeTabVariant?
}