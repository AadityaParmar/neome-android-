// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdPrompt

open class DtoEntPrompt {
    lateinit var actionId: MetaIdAction
    var description: String? = null
    var hint: String? = null
    lateinit var metaId: MetaIdPrompt
    lateinit var name: Symbol
}
