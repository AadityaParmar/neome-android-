// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar

class StudioMapOfJarFile : StudioBase() {
    val keys: MediaIdJar[]
    val map: Record<MediaIdJar, StudioDtoJarFile>
}
