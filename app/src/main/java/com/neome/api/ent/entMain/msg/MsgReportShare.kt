// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgReportShare : Msg() {
    val actionId: MetaIdAction
    var inputFormValueRaw: FormValueRaw? = null
    val reportId: MetaIdReport
    var reset: boolean? = null
}
