// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioPluginDeploy : StudioBase() {
    var changes: String? = null
    lateinit var pluginVersion: String
}
