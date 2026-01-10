// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole

interface StudioFieldLogDecimal : StudioFieldDecimal {
    val logReadRoleSet: List<MetaIdRole>?
}
