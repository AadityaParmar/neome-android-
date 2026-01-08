// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MediaIdDocument

interface FieldSetOfDocument
{
  val fileExtSet: Array<EnumDefnDocFileExt>
  val fileNameSet: Array<String>
  val fileSizeSet: Array<Number>
  val mediaIdDocumentSet: Array<MediaIdDocument>
}