// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioDtoRowIdPointer

open class EntVdRowGetHistory : EntVdAutoStepWithOutput() {
    var offset: StudioDtoArgValueParameter? = null
    var pageSize: Number? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
}
