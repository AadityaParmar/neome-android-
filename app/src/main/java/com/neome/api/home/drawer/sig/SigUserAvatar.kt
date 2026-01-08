// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.sig.SigVersion

interface SigUserAvatar : SigVersion
{
  val about: String?
  val avatarId: MediaId?
  val entId: EntId
  val entUserId: EntUserId
  val firstName: String
  val handle: String?
  val isBlocked: Boolean?
  val isDeleted: Boolean?
  val lastName: String
  val nickName: String?
  val userColor: String
}