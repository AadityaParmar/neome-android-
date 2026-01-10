package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.home.base.dto.DtoChatBubbleHeader
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessagePayloadSpreadsheetPartition
import com.neome.api.home.base.dto.DtoPartition
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoChatBubbleHeaderData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.api.home.base.dto.DtoPartitionData
import com.neome.core.common.serializer.api.home.main.sig.SigSpreadsheetRowData
import com.neome.core.common.serializer.sysId.ContactIdSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import com.neome.core.common.serializer.sysId.SpreadsheetPartitionIdSer
import kotlinx.serialization.Serializable


@Serializable
sealed interface DtoMessagePayloadSpreadsheetPartitionSeal : DtoMessagePayloadSpreadsheetPartition


@Serializable
data class DtoMessagePayloadSpreadsheetPartitionData(
    override val isForwarded: Boolean? = null,
    override val mentionMap: Map<String, @Serializable(with = ContactIdSer::class) Types.ContactId>? = null,
    override val messageType: EnumMessageType,
    override val chatBubbleHeader: DtoChatBubbleHeaderData,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val partitionList: List<DtoPartitionData>? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    @Serializable(with = SpreadsheetPartitionIdSer::class) override val spreadsheetPartitionId: Types.SpreadsheetPartitionId,
    override val spreadsheetRow: SigSpreadsheetRowData? = null
) : DtoMessagePayloadSeal, DtoMessagePayloadSpreadsheetPartition
