// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaIdDocument

class FieldSetOfDocument {
    val fileExtSet: EnumDefnDocFileExt[]
    val fileNameSet: string[]
    val fileSizeSet: number[]
    val mediaIdDocumentSet: MediaIdDocument[]
}
