// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import java.util.Date
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.sig.Sig

interface SigUserLastOnline : Sig
{
  val entId: EntId
  val entUserId: EntUserId
  val lastOnline: String?
  val online: Boolean?
}