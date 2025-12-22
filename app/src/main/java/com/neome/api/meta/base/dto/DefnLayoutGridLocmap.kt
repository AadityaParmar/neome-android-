// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

class DefnLayoutGridLocmap : DefnLayoutGrid() {
    var lineStroke: DefnDtoLayoutLocmapLineStroke? = null
    var liveLocationPin: DefnDtoLayoutLocmapPin? = null
    var locationFieldId: MetaIdField? = null
    var mapPin: DefnDtoLayoutLocmapPin? = null
    var renderingMode: EnumDefnMapRenderingMode? = null
}
