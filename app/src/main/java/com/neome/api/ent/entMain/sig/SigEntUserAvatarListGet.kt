// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.EntUserId
import java.util.Map
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.nucleus.base.sig.SigVersion

open class SigEntUserAvatarListGet : SigVersion()
{
  lateinit var avatarMap: Map<EntUserId, SigUserAvatar>
}