// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdPrompt

class DtoEntPrompt {
    val actionId: MetaIdAction
    var description: string? = null
    var hint: string? = null
    val metaId: MetaIdPrompt
    val name: Symbol
}
