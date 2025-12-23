// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdAiTextToForm : EntVdAiWithOutput() {
    var inputField: StudioDtoArgValueParameter? = null
    var outputForm: FormRefKey? = null
}
