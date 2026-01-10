// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite

interface StudioCompositeMap : StudioBase {
    val keys: List<MetaIdComposite>
    val map: Map<MetaIdComposite, StudioComposite>
}
