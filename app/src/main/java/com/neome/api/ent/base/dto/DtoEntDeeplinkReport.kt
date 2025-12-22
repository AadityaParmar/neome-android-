// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport

class DtoEntDeeplinkReport : DtoEntDeeplink() {
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    var reportId: MetaIdReport? = null
}
