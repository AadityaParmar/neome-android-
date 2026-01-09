package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoChatBubbleHeader
import com.neome.api.meta.base.dto.StudioEntAction
import com.neome.api.meta.base.dto.StudioEntActionRowInsert
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioEntActionRowInsertData(
    override val aiInstructions: String? = null,
    override val defaultValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    override val details: StudioDetails,
    override val icon: String? = null,
    override val increaseAsideWidth: Boolean? = null,
    override val kind: EnumDefnKindAction,
    @Serializable(with = MetaIdActionSer::class) override val metaId: Types.MetaIdAction,
    override val tooltip: String? = null,
    override val chatBubbleHeader: StudioDtoChatBubbleHeader? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formEditorLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileFormEditorLayoutId: Types.MetaIdLayoutForm? = null,
    override val sendMessageToInbox: Boolean? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : StudioEntActionRowInsert
