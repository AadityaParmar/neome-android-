// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntUserAvatarListGet : SigVersion() {
    val avatarMap: Record<EntUserId, SigUserAvatar>
}
