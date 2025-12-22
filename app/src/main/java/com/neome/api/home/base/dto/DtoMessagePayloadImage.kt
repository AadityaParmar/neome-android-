// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdImage

class DtoMessagePayloadImage : DtoMessagePayloadText() {
    val fileSize: number
    val height: number
    val mediaIdBlurImage: MediaIdImage
    val mediaIdImage: MediaIdImage
    val primaryColor: string
    val width: number
}
