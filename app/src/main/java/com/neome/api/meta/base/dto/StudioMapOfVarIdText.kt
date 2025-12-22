// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class StudioMapOfVarIdText : StudioBase() {
    val keys: string[]
    val map: Record<string, StudioValueVarIdText>
}
