// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioComposite : StudioComp() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    lateinit var fieldMap: StudioFieldMap
}
