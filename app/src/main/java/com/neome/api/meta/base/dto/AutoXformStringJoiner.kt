// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class AutoXformStringJoiner : AutoXform() {
    var outputField: StudioDtoArgValueParameter? = null
    var separator: StudioBuildArgBinder? = null
    var sourceFieldMap: StudioMapOfArgBinder? = null
}
