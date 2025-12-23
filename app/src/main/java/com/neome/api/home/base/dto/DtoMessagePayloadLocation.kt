// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import kotlin.properties.Delegates

open class DtoMessagePayloadLocation : DtoMessagePayloadText() {
    var city: String? = null
    var country: String? = null
    var latitude: Number by Delegates.notNull<Number>()
    var longitude: Number by Delegates.notNull<Number>()
    lateinit var mediaIdImage: MediaIdImage
}
