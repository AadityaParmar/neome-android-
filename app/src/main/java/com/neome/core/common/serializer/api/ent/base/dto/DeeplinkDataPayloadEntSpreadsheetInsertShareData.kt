package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntSpreadsheetInsertShare
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DeeplinkDataPayloadEntSpreadsheetInsertShareData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeader? = null,
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId? = null,
    override val defnForm: DefnForm,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formEditorLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdActionSer::class) override val metaIdAction: Types.MetaIdAction? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val mobileFormEditorLayoutId: Types.MetaIdLayoutForm? = null,
    override val repeatButtonLabel: String? = null,
    override val sendMessageToInbox: Boolean? = null,
    override val showRepeatButton: Boolean? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val successMessage: DefnDtoParagraph,
    override val successMessageBgColor: DefnDtoColor? = null,
    override val successMessageTextSize: EnumDefnTextSize? = null,
    override val valueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null
) : DeeplinkDataPayloadEntSpreadsheetInsertShare
