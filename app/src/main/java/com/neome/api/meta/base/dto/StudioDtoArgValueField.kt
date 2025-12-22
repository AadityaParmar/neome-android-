// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoArgValueField : StudioDtoArgValue() {
    var compositeId: MetaIdComposite? = null
    val fieldId: MetaIdField
    var valuePathArray: string[]? = null
}
