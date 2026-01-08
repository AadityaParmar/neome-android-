// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.FormValue
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPrompt

interface DtoPromptAction
{
  val executeOnClient: Boolean
  val formValue: FormValue?
  val promptActionId: MetaIdAction?
  val promptId: MetaIdPrompt?
  val ragFormId: MetaIdForm?
}