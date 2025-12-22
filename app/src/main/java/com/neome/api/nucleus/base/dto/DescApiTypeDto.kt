// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

class DescApiTypeDto : DescApiType() {
    val dtoDir: string
    var fieldMapJava: Record<string, string>? = null
    var fieldMapTypeScript: Record<string, string>? = null
    var importMap: Record<string, string>? = null
    var superClass: string? = null
}
