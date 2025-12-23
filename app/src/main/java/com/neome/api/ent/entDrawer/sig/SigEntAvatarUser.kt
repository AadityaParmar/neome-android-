// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

open class SigEntAvatarUser : SigVersion()
{
  var about: String? = null
  var avatarId: MediaIdAvatar? = null
  lateinit var entId: EntId
  lateinit var name: String
}