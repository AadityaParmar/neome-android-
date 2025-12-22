// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVdAutoFunc

class EntVdApplyTransforms : EntVdAutoStep() {
    val keys: MetaIdVdAutoFunc[]
    val map: Record<MetaIdVdAutoFunc, AutoXform>
}
