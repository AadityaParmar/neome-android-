// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole

class DefnFieldLogCounter : DefnFieldCounter() {
    var hideInfo: boolean? = null
    var logReadRoleSet: MetaIdRole[]? = null
}
