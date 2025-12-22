// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntDeployVarMap : StudioBase() {
    val keys: MetaIdVar[]
    val map: Record<MetaIdVar, StudioEntDeployVar>
}
