// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm

class DefnLayoutFormMap {
    var asideDefaultLayoutId: MetaIdLayoutForm? = null
    val keys: MetaIdLayoutForm[]
    val map: Record<MetaIdLayoutForm, DefnLayoutForm>
    var mobileDefaultLayoutId: MetaIdLayoutForm? = null
}
