// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindReport
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdReport
import java.util.Map

open class DtoEntActionReport : DtoEntAction() {
    var defaultValueMap: Map<MetaIdComp, Any>? = null
    var inputFormId: MetaIdForm? = null
    var outputFormContentLayoutId: MetaIdLayoutForm? = null
    lateinit var outputFormId: MetaIdForm
    var outputFormTemplateLayoutId: MetaIdLayoutForm? = null
    lateinit var reportId: MetaIdReport
    lateinit var reportKind: EnumDefnKindReport
    var sendMessageToInbox: Boolean? = null
}
