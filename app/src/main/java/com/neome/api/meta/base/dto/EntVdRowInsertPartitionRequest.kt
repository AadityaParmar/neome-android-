// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class EntVdRowInsertPartitionRequest : EntVdAutoStep() {
    var fromSender: StudioBuildArgBinder? = null
    var requestBubbleHeader: StudioDtoChatBubbleHeader? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
    var toGroupIdSet: MetaIdGroup[]? = null
}
