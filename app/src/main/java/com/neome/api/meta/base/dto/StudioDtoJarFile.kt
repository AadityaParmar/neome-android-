// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoJarFile : StudioBase
{
  val fileName: String
  val md5: String
  val metaId: MediaIdJar
}