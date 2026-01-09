package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntSpreadsheetEditorShare
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntSpreadsheetEditorShareData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeader? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid,
    @Serializable(with = MetaIdActionSer::class) override val metaIdAction: Types.MetaIdAction,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val metaIdSpreadsheet: Types.MetaIdSpreadsheet
) : DeeplinkDataPayloadEntSpreadsheetEditorShare
