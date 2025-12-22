// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdImageFunc

class EntVdImageTransforms : EntVdAutoStep() {
    var inputField: StudioDtoArgValueParameter? = null
    val keys: MetaIdVdImageFunc[]
    val map: Record<MetaIdVdImageFunc, ImageXform>
    var outputField: StudioDtoArgValueParameter? = null
}
