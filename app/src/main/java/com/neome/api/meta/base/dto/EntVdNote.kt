// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnKindNoteStatus
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdVdNote
import com.neome.api.meta.base.Types.MetaIdVdRegion

class EntVdNote : EntVdRect() {
    var adminId: AdminId? = null
    val metaId: MetaIdVdNote
    var parentRegionId: MetaIdVdRegion? = null
    var status: EnumDefnKindNoteStatus? = null
    var textSize: EnumDefnTextSize? = null
    var value: string? = null
}
