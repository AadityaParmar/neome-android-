// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

interface StudioMapOfArgBinder : StudioBase {
    val keys: List<String>
    val map: Map<String, StudioBuildArgBinder>
}
