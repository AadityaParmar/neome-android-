// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdApplyFormula : EntVdAutoStepWithError() {
    var assignToField: StudioDtoArgValueParameter? = null
    var javascriptFormula: StudioValueCodeJavascript? = null
}
