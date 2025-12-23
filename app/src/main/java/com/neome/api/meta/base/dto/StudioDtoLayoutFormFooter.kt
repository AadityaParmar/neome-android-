// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoLayoutFormFooter : StudioBase() {
    var footerImage: FieldDtoImage? = null
    var footerImageHeight: Number? = null
    var footerImageVarId: MetaIdVar? = null
    var formLayoutId: MetaIdLayoutForm? = null
    var showSeparator: Boolean? = null
}
