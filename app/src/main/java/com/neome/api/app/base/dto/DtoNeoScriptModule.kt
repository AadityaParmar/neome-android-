// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdModule

open class DtoNeoScriptModule : DtoNeoScript() {
    var moduleId: MetaIdModule? = null
}
