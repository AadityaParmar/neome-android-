// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import kotlin.properties.Delegates

open class DtoGroupSettings
{
  var anyOneCanJoin: Boolean by Delegates.notNull<Boolean>()
  var onlyAdminCanSendMessages: Boolean by Delegates.notNull<Boolean>()
  var onlyAdminCanUpdateGroupInfo: Boolean by Delegates.notNull<Boolean>()
}