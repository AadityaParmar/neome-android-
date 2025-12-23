// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.studio.base.dto.DtoSecretKey
import com.neome.api.meta.base.Types.EnumKeychainType
import com.neome.api.meta.base.Types.KeychainId
import com.neome.api.meta.base.Types.KeychainSecretId
import java.util.Map

open class DtoKeychain {
    var createdAt: String? = null
    var createdBy: AdminId? = null
    var description: String? = null
    lateinit var keychainId: KeychainId
    lateinit var name: String
    var secretKey: String? = null
    var secretKeyMap: Map<KeychainSecretId, DtoSecretKey>? = null
    lateinit var type: EnumKeychainType
    var updatedAt: String? = null
    var updatedBy: AdminId? = null
}
