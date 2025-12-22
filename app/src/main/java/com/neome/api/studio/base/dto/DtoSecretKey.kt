// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId

class DtoSecretKey : DtoSecretKeyBase() {
    var createdAt: string? = null
    var createdBy: AdminId? = null
    var updatedAt: string? = null
    var updatedBy: AdminId? = null
}
