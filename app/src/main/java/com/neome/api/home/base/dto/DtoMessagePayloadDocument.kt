// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdDocument

class DtoMessagePayloadDocument : DtoMessagePayload() {
    val fileExt: string
    val fileName: string
    val fileSize: number
    val mediaIdDocument: MediaIdDocument
}
