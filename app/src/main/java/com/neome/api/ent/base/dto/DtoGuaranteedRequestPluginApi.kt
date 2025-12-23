// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

open class DtoGuaranteedRequestPluginApi : DtoGuaranteedRequest() {
    lateinit var pluginApiRequest: DtoPluginApiRequestPayload
}
