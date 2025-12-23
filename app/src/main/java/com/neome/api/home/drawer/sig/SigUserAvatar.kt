// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.sig.SigVersion

open class SigUserAvatar : SigVersion()
{
  var about: String? = null
  var avatarId: MediaId? = null
  lateinit var entId: EntId
  lateinit var entUserId: EntUserId
  lateinit var firstName: String
  var handle: String? = null
  var isBlocked: Boolean? = null
  var isDeleted: Boolean? = null
  lateinit var lastName: String
  var nickName: String? = null
  lateinit var userColor: String
}