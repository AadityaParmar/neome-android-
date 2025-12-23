// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import java.util.Map

open class StudioCompositeMap : StudioBase() {
    lateinit var keys: Array<MetaIdComposite>
    lateinit var map: Map<MetaIdComposite, StudioComposite>
}
