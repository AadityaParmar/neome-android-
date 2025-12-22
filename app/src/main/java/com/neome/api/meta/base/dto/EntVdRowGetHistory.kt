// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class EntVdRowGetHistory : EntVdAutoStepWithOutput() {
    var offset: StudioDtoArgValueParameter? = null
    var pageSize: number? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
}
