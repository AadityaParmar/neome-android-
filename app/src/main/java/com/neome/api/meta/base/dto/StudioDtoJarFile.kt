// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MediaIdJar

class StudioDtoJarFile : StudioBase() {
    val fileName: string
    val md5: string
    val metaId: MediaIdJar
}
