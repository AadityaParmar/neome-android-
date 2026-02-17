// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdImage

interface FieldDtoImage
{
  val fileName: String
  val height: Long
  val mediaIdBlurImage: MediaIdImage
  val mediaIdImage: MediaIdImage
  val primaryColor: String
  val size: Long
  val width: Long
}