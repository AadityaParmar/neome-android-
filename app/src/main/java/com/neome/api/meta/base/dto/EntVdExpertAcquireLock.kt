// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class EntVdExpertAcquireLock : EntVdAutoStepWithError() {
    var duration: FieldDtoDuration? = null
    var lockKey: StudioValueText? = null
}
