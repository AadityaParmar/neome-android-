// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.KeychainSecretId

open class DtoSecretKeyBase
{
  var description: String? = null
  lateinit var name: String
  lateinit var secretKey: String
  lateinit var secretKeyId: KeychainSecretId
}