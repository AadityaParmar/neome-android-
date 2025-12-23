// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

open class MsgReportShare : Msg() {
    lateinit var actionId: MetaIdAction
    var inputFormValueRaw: FormValueRaw? = null
    lateinit var reportId: MetaIdReport
    var reset: Boolean? = null
}
