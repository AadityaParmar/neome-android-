// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaIdDocument

open class FieldSetOfDocument {
    lateinit var fileExtSet: Array<EnumDefnDocFileExt>
    lateinit var fileNameSet: Array<String>
    lateinit var fileSizeSet: Array<Number>
    lateinit var mediaIdDocumentSet: Array<MediaIdDocument>
}
