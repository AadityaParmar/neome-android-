// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgButtonWorkflowExecute : Msg() {
    val buttonFieldId: MetaIdField
    val buttonFormId: MetaIdForm
    val formValue: FormValueRaw
    var fromGridId: MetaIdGrid? = null
    var fromGridRowId: RowId? = null
}
