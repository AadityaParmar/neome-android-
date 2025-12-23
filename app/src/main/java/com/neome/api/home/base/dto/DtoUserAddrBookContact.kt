// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar

open class DtoUserAddrBookContact
{
  lateinit var entUserId: EntUserId
  lateinit var handle: String
  var mediaIdAvatar: MediaIdAvatar? = null
  lateinit var nickName: String
}