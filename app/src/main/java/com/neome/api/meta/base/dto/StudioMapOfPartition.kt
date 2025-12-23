// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPartition
import java.util.Map

open class StudioMapOfPartition : StudioBase() {
    var keys: Array<MetaIdPartition>? = null
    lateinit var map: Map<MetaIdPartition, StudioDtoPartition>
}
