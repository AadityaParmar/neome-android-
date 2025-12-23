// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MediaIdDocument
import kotlin.properties.Delegates

open class DtoMessagePayloadDocument : DtoMessagePayload() {
    lateinit var fileExt: String
    lateinit var fileName: String
    var fileSize: Number by Delegates.notNull<Number>()
    lateinit var mediaIdDocument: MediaIdDocument
}
