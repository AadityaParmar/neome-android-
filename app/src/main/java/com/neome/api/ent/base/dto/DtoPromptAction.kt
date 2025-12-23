// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPrompt

open class DtoPromptAction
{
  var executeOnClient: Boolean by Delegates.notNull<Boolean>()
  var formValue: FormValue? = null
  var promptActionId: MetaIdAction? = null
  var promptId: MetaIdPrompt? = null
  var ragFormId: MetaIdForm? = null
}