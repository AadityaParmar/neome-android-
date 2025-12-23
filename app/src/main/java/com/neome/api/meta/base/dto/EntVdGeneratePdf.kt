// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm

open class EntVdGeneratePdf : EntVdAutoStep() {
    var contentLayoutId: MetaIdLayoutForm? = null
    var fileName: StudioValueText? = null
    var outputField: StudioDtoArgValueParameter? = null
    var templateLayoutId: MetaIdLayoutForm? = null
}
