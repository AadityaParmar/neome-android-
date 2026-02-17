package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoChatMessageListMap
import com.neome.api.home.drawer.sig.SigDrawerSearch
import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.home.base.dto.DtoChatMessageListMapData
import com.neome.core.common.serializer.api.home.drawer.sig.SigGroupAvatarData
import com.neome.core.common.serializer.api.home.drawer.sig.SigUserAvatarData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigDrawerSearchData(
    override val auditRecordMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, List<FormValueData>>>? = null,
    override val groupAvatarList: List<SigGroupAvatarData>? = null,
    override val latestMessageMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoChatMessageListMapData>? = null,
    override val spreadsheetRowMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, Map<@Serializable(with = MetaIdSpreadsheetSer::class) Types.MetaIdSpreadsheet, Set<@Serializable(with = RowIdSer::class) Types.RowId>>>? = null,
    override val totalMessageCount: Long,
    override val userAvatarList: List<SigUserAvatarData>? = null
) : SigDrawerSearch
