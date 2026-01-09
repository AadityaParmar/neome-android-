package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.SpreadsheetPartitionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowData(
    override val version: String,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val formValue: FormValueRaw? = null,
    override val rowCommentCount: SigSpreadsheetRowCommentCount? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet,
    @Serializable(with = SpreadsheetPartitionIdSer::class) override val spreadsheetPartitionId: Types.SpreadsheetPartitionId,
    override val updatedKeySet: Array<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>? = null
) : SigSpreadsheetRow
