// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

open class DtoNeoScriptVar : DtoNeoScript() {
    var varId: MetaIdVar? = null
}
