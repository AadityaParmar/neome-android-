// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar
import java.util.Map

open class StudioMapOfJarFile : StudioBase() {
    lateinit var keys: Array<MediaIdJar>
    lateinit var map: Map<MediaIdJar, StudioDtoJarFile>
}
