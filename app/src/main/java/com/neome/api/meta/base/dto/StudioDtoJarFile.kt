// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar
import com.neome.api.meta.base.dto.StudioBase

open class StudioDtoJarFile : StudioBase()
{
  lateinit var fileName: String
  lateinit var md5: String
  lateinit var metaId: MediaIdJar
}