// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

class SigEntAvatarUser : SigVersion() {
    var about: string? = null
    var avatarId: MediaIdAvatar? = null
    val entId: EntId
    val name: string
}
