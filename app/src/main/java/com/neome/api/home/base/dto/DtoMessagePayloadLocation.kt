// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdImage

class DtoMessagePayloadLocation : DtoMessagePayloadText() {
    var city: string? = null
    var country: string? = null
    val latitude: number
    val longitude: number
    val mediaIdImage: MediaIdImage
}
