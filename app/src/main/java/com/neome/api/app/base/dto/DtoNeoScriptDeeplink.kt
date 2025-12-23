// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdDeeplink

open class DtoNeoScriptDeeplink : DtoNeoScript() {
    var deeplinkId: MetaIdDeeplink? = null
}
