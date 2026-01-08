// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser

interface SigEntInvitationList : Sig
{
  val entList: Array<SigEntAvatarUser>?
}