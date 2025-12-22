// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DtoEntActionRowInsert : DtoEntAction() {
    var defaultValueMap: Record<MetaIdComp, any>? = null
    var formEditorLayoutId: MetaIdLayoutForm? = null
    var hasPartitions: boolean? = null
    var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
    var sendMessageToInbox: boolean? = null
    val spreadsheetFormId: MetaIdForm
    val spreadsheetId: MetaIdSpreadsheet
}
