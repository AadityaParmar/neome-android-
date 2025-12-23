// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw

open class DtoMessagePayloadReport : DtoMessagePayload() {
    lateinit var actionId: MetaIdAction
    var formValueRaw: FormValueRaw? = null
    var inputFormId: MetaIdForm? = null
    var reportId: MetaIdReport? = null
    var reportLabel: String? = null
    var reportName: String? = null
    var rowId: RowId? = null
}
