// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.KeychainSecretId

class DtoSecretKeyBase {
    var description: string? = null
    val name: string
    val secretKey: string
    val secretKeyId: KeychainSecretId
}
