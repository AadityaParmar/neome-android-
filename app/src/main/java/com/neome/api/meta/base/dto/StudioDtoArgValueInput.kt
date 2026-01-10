// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField

interface StudioDtoArgValueInput : StudioDtoArgValue {
    val compositeId: MetaIdComposite?
    val fieldId: MetaIdField
    val valuePathArray: List<String>?
}
