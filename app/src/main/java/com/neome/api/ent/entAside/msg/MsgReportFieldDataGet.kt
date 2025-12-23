// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

open class MsgReportFieldDataGet : Msg() {
    lateinit var formId: MetaIdForm
    var inputFormCompositeId: MetaIdComposite? = null
    var inputFormGridRowId: RowId? = null
    lateinit var inputFormValue: FormValueRaw
    lateinit var reportFieldId: MetaIdField
}
