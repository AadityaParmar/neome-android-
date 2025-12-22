// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

class StudioDtoLayoutLocmap : StudioDtoLayoutGrid() {
    var lineStroke: StudioDtoLayoutLocmapLineStroke? = null
    var liveLocationPin: StudioDtoLayoutLocmapPin? = null
    var locationFieldId: MetaIdField? = null
    var mapPin: StudioDtoLayoutLocmapPin? = null
    var renderingMode: EnumDefnMapRenderingMode? = null
}
