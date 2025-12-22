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

class MsgButtonFieldReportDataGet : Msg() {
    val buttonFieldId: MetaIdField
    val formId: MetaIdForm
    val formValue: FormValueRaw
    var fromCompositeId: MetaIdComposite? = null
    var fromGridRowId: RowId? = null
}
