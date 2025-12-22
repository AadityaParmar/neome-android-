// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatMessageListMap
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig

class SigDrawerSearch : Sig() {
    var auditRecordMap: Record<EntId, Record<MetaIdSpreadsheet, FormValue[]>>? = null
    var groupAvatarList: SigGroupAvatar[]? = null
    var latestMessageMap: Record<EntId, DtoChatMessageListMap>? = null
    var spreadsheetRowMap: Record<EntId, Record<MetaIdSpreadsheet, RowId[]>>? = null
    val totalMessageCount: number
    var userAvatarList: SigUserAvatar[]? = null
}
