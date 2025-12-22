// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport

class StudioEntReport : StudioBase() {
    val details: StudioDetails
    var inputFormId: MetaIdForm? = null
    val kind: EnumDefnKindReport
    val metaId: MetaIdReport
    var outputFormId: MetaIdForm? = null
}
