package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumAuditAction
import com.neome.api.ent.base.dto.DtoAuditRecord
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAuditRecordData(
    override val auditAction: EnumAuditAction? = null,
    override val dateTime: String? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    override val formValueRefKey: String? = null,
    override val historyFieldLabelSet: Array<String>? = null,
    override val historyFieldValueSet: Array<String>? = null,
    override val offset: String? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val spreadsheetName: String? = null,
    override val version: String? = null
) : DtoAuditRecord
