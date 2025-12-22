// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

class StudioEntActionMap : StudioBase() {
    val keys: MetaIdAction[]
    val map: Record<MetaIdAction, StudioEntAction>
}
