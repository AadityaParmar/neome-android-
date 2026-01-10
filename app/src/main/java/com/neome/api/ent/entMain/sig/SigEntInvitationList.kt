// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.nucleus.base.sig.Sig

interface SigEntInvitationList : Sig {
    val entList: List<SigEntAvatarUser>?
}
