// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

class SigGroupAvatar : SigVersion() {
    var about: string? = null
    var avatarId: MediaIdAvatar? = null
    val entId: EntId
    val groupId: GroupId
    var isAdmin: boolean? = null
    val isMember: boolean
    var label: string? = null
    val name: string
}
