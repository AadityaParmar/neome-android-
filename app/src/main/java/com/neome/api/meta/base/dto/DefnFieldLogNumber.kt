// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole

open class DefnFieldLogNumber : DefnFieldNumber() {
    var hideInfo: Boolean? = null
    var logReadRoleSet: Array<MetaIdRole>? = null
}
