// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map

open class DescApiTypeDto : DescApiType() {
    lateinit var dtoDir: String
    var fieldMapJava: Map<String, String>? = null
    var fieldMapTypeScript: Map<String, String>? = null
    var importMap: Map<String, String>? = null
    var superClass: String? = null
}
