// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

open class DtoEntUserImport
{
  lateinit var handle: String
  var manager: String? = null
  lateinit var nickName: String
  var roles: Array<String>? = null
}