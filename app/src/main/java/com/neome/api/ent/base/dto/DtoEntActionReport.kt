// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport

class DtoEntActionReport : DtoEntAction() {
    var defaultValueMap: Record<MetaIdComp, any>? = null
    var inputFormId: MetaIdForm? = null
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    val outputFormId: MetaIdForm
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    val reportId: MetaIdReport
    val reportKind: EnumDefnKindReport
    var sendMessageToInbox: boolean? = null
}
