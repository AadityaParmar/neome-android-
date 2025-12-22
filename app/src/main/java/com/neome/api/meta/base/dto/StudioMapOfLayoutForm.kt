// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm

class StudioMapOfLayoutForm : StudioBase() {
    var asideDefaultLayoutId: MetaIdLayoutForm? = null
    val keys: MetaIdLayoutForm[]
    val map: Record<MetaIdLayoutForm, StudioDtoLayoutForm>
    var mobileDefaultLayoutId: MetaIdLayoutForm? = null
}
