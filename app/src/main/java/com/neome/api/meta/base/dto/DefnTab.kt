// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeTabVariant
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdTab

class DefnTab : DefnComp() {
    val metaId: MetaIdTab
    var showAsTree: boolean? = null
    var showDivider: boolean? = null
    var showSingleTab: boolean? = null
    var tabIdSet: MetaIdComposite[]? = null
    var tabVariant: EnumDefnThemeTabVariant? = null
}
