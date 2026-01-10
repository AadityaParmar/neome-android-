// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar

interface StudioMapOfJarFile : StudioBase {
    val keys: List<MediaIdJar>
    val map: Map<MediaIdJar, StudioDtoJarFile>
}
