package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatMessageListMap
import com.neome.api.home.drawer.sig.SigDrawerSearch
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigDrawerSearchData(
    override val auditRecordMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, Array<FormValue>>>? = null,
    override val groupAvatarList: Array<SigGroupAvatar>? = null,
    override val latestMessageMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoChatMessageListMap>? = null,
    override val spreadsheetRowMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, Array<@Serializable(with = RowIdSer::class) Types.RowId>>>? = null,
    override val totalMessageCount: Long? = null,
    override val userAvatarList: Array<SigUserAvatar>? = null
) : SigDrawerSearch
