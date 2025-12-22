// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumKeychainType
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.Types.KeychainSecretId

class DtoKeychain {
    var createdAt: string? = null
    var createdBy: AdminId? = null
    var description: string? = null
    val keychainId: KeychainId
    val name: string
    var secretKey: string? = null
    var secretKeyMap: Record<KeychainSecretId, DtoSecretKey>? = null
    val type: EnumKeychainType
    var updatedAt: string? = null
    var updatedBy: AdminId? = null
}
