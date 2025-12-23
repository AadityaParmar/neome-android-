// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import java.util.Map

open class DtoEntActionRowInsert : DtoEntAction() {
    var defaultValueMap: Map<MetaIdComp, Any>? = null
    var formEditorLayoutId: MetaIdLayoutForm? = null
    var hasPartitions: Boolean? = null
    var mobileFormEditorLayoutId: MetaIdLayoutForm? = null
    var sendMessageToInbox: Boolean? = null
    lateinit var spreadsheetFormId: MetaIdForm
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
