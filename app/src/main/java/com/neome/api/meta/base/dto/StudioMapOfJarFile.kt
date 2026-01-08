// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoJarFile

interface StudioMapOfJarFile : StudioBase
{
  val keys: Array<MediaIdJar>
  val map: Map<MediaIdJar, StudioDtoJarFile>
}