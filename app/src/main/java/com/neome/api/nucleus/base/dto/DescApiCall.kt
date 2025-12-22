// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

class DescApiCall {
    var call: Record<string, SpecApi>? = null
    var importMap: Record<string, string>? = null
    val pathSeg: string
}
