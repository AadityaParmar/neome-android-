// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntDeeplinkWithHeader : StudioEntDeeplink() {
    var hyperlinkVarIdSet: Array<MetaIdVar>? = null
    var showEnterprise: Boolean? = null
    var showHeader: Boolean? = null
    var transparentHeader: Boolean? = null
}
