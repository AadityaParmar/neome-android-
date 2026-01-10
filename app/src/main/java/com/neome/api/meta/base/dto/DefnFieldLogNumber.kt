// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole

interface DefnFieldLogNumber : DefnFieldNumber {
    val hideInfo: Boolean?
    val logReadRoleSet: List<MetaIdRole>?
}
