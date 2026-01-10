// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

interface StudioFormMap : StudioBase {
    val keys: List<MetaIdForm>
    val map: Map<MetaIdForm, StudioForm>
}
