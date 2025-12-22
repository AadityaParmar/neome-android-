// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgFormMappingResultGet : Msg() {
    var inputFormGridRowId: RowId? = null
    val inputFormId: MetaIdForm
    val inputFormValueRaw: FormValueRaw
    val mappingVarId: MetaIdVar
    var outputFormGridRowId: RowId? = null
    val outputFormId: MetaIdForm
    var outputFormValueRaw: FormValueRaw? = null
}
