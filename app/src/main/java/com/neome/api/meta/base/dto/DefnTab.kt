// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdTab

open class DefnTab : DefnComp()
{
  lateinit var metaId: MetaIdTab
  var showAsTree: Boolean? = null
  var showDivider: Boolean? = null
  var showSingleTab: Boolean? = null
  var tabIdSet: Array<MetaIdComposite>? = null
  var tabVariant: EnumDefnThemeTabVariant? = null
}