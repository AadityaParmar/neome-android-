// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoUserAddrBookContact
{
  val entUserId: EntUserId
  val handle: String
  val mediaIdAvatar: MediaIdAvatar?
  val nickName: String
}