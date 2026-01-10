package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntSpreadsheetRowShare
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.api.ent.base.dto.DeeplinkDataPayloadEntHeaderData
import com.neome.core.common.serializer.api.home.main.sig.SigSpreadsheetRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.sysId.MetaIdLayoutFormSer
import kotlinx.serialization.Serializable


@Serializable
data class DeeplinkDataPayloadEntSpreadsheetRowShareData(
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val header: DeeplinkDataPayloadEntHeaderData? = null,
    override val defnForm: DefnFormData? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formContentLayoutId: Types.MetaIdLayoutForm? = null,
    @Serializable(with = MetaIdLayoutFormSer::class) override val formTemplateLayoutId: Types.MetaIdLayoutForm? = null,
    override val isPublicUpdateAllowed: Boolean? = null,
    override val spreadsheetRow: SigSpreadsheetRowData? = null
) : DeeplinkDataPayloadEntSpreadsheetRowShare
