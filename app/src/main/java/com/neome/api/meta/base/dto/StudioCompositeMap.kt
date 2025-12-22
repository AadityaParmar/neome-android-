// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite

class StudioCompositeMap : StudioBase() {
    val keys: MetaIdComposite[]
    val map: Record<MetaIdComposite, StudioComposite>
}
