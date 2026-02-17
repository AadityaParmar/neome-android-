// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoPromptAction
import com.neome.api.nucleus.base.sig.Sig

interface SigPromptActions : Sig
{
  val executedPromptActionList: List<DtoPromptAction>?
  val reviewPromptActionList: List<DtoPromptAction>?
}