// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPrompt
import com.neome.api.meta.base.dto.FormValue

class DtoPromptAction {
    val executeOnClient: boolean
    var formValue: FormValue? = null
    var promptActionId: MetaIdAction? = null
    var promptId: MetaIdPrompt? = null
    var ragFormId: MetaIdForm? = null
}
