// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

interface SigEntAvatarUser : SigVersion
{
  val about: String?
  val avatarId: MediaIdAvatar?
  val entId: EntId
  val name: String
}