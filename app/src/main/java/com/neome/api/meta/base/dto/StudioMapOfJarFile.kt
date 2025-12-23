// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MediaIdJar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoJarFile

open class StudioMapOfJarFile : StudioBase()
{
  lateinit var keys: Array<MediaIdJar>
  lateinit var map: Map<MediaIdJar, StudioDtoJarFile>
}