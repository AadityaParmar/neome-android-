// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.FormValueRaw

open class MsgSpreadsheetRefFieldDataGet : MsgVersion() {
    var ascOrder: Boolean? = null
    lateinit var formId: MetaIdForm
    var formSpreadsheetId: MetaIdSpreadsheet? = null
    lateinit var inputFormValueRaw: FormValueRaw
    lateinit var refFieldId: MetaIdComp
    var sortByFieldIdSet: Array<MetaIdField>? = null
}
