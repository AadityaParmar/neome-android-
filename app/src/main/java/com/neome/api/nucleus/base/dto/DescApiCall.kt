// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map

open class DescApiCall {
    var call: Map<String, SpecApi>? = null
    var importMap: Map<String, String>? = null
    lateinit var pathSeg: String
}
