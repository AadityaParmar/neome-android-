// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnLayoutFormMap {
    val asideDefaultLayoutId: MetaIdLayoutForm?
    val keys: List<MetaIdLayoutForm>
    val map: Map<MetaIdLayoutForm, DefnLayoutForm>
    val mobileDefaultLayoutId: MetaIdLayoutForm?
}
