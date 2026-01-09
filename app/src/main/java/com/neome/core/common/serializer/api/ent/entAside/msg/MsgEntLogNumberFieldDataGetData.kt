package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgEntLogNumberFieldDataGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntLogNumberFieldDataGetData(
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    @Serializable(with = MetaIdGridSer::class) override val gridId: Types.MetaIdGrid? = null,
    @Serializable(with = RowIdSer::class) override val gridRowId: Types.RowId? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : MsgEntLogNumberFieldDataGet
