package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRefFieldDataGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRefFieldDataGetData(
    override val version: String? = null,
    override val ascOrder: Boolean? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val formSpreadsheetId: Types.MetaIdSpreadsheet? = null,
    override val inputFormValueRaw: FormValueRaw,
    @Serializable(with = MetaIdCompSer::class) override val refFieldId: Types.MetaIdComp,
    override val sortByFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null
) : MsgSpreadsheetRefFieldDataGet
