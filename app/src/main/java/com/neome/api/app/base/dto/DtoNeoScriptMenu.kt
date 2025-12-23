// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdForm

open class DtoNeoScriptMenu : DtoNeoScript() {
    var compositeId: MetaIdComposite? = null
    var formId: MetaIdForm? = null
}
