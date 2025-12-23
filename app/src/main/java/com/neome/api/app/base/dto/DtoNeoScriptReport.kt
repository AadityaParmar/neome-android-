// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdReport

open class DtoNeoScriptReport : DtoNeoScript() {
    var reportId: MetaIdReport? = null
}
