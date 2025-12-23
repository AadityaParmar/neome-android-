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
import java.util.Map
import kotlin.properties.Delegates

open class SigDrawerSearch : Sig() {
    var auditRecordMap: Map<EntId, Map<MetaIdSpreadsheet, Array<FormValue>>>? = null
    var groupAvatarList: Array<SigGroupAvatar>? = null
    var latestMessageMap: Map<EntId, DtoChatMessageListMap>? = null
    var spreadsheetRowMap: Map<EntId, Map<MetaIdSpreadsheet, Array<RowId>>>? = null
    var totalMessageCount: Number by Delegates.notNull<Number>()
    var userAvatarList: Array<SigUserAvatar>? = null
}
