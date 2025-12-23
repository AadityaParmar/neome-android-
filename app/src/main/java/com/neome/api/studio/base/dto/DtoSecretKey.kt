// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId

open class DtoSecretKey : DtoSecretKeyBase() {
    var createdAt: String? = null
    var createdBy: AdminId? = null
    var updatedAt: String? = null
    var updatedBy: AdminId? = null
}
