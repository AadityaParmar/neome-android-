// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

interface SigGroupAvatar : SigVersion
{
  val about: String?
  val avatarId: MediaIdAvatar?
  val entId: EntId
  val groupId: GroupId
  val isAdmin: Boolean?
  val isMember: Boolean
  val label: String?
  val name: String
}