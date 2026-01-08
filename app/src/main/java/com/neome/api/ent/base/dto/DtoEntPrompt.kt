// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.Symbol

interface DtoEntPrompt
{
  val actionId: MetaIdAction
  val description: String?
  val hint: String?
  val metaId: MetaIdPrompt
  val name: Symbol
}