// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar

interface DtoNewChatCandidate
{
  val groupAvatar: SigGroupAvatar?
  val userAvatar: SigUserAvatar?
}