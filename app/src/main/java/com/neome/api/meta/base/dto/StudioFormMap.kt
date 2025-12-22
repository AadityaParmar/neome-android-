// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

class StudioFormMap : StudioBase() {
    val keys: MetaIdForm[]
    val map: Record<MetaIdForm, StudioForm>
}
