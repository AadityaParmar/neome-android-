// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField

open class StudioDtoArgValueOutput : StudioDtoArgValue() {
    var compositeId: MetaIdComposite? = null
    var fieldId: MetaIdField? = null
}
