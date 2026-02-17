// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage
import com.neome.api.meta.base.Types.MediaIdVideo

interface FieldValueVideo
{
  val durationMs: Long
  val fileName: String?
  val mediaIdBlurImage: MediaIdImage
  val mediaIdImage: MediaIdImage
  val mediaIdVideo: MediaIdVideo
  val primaryColor: String
  val size: Long
}