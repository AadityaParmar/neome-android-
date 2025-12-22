// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntDeeplinkWithHeader : StudioEntDeeplink() {
    var hyperlinkVarIdSet: MetaIdVar[]? = null
    var showEnterprise: boolean? = null
    var showHeader: boolean? = null
    var transparentHeader: boolean? = null
}
