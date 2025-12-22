// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport

class StudioEntDeeplinkReport : StudioEntDeeplinkWithHeader() {
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    var reportId: MetaIdReport? = null
}
