// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

open class DtoNeoScriptAction : DtoNeoScript() {
    var actionId: MetaIdAction? = null
}
