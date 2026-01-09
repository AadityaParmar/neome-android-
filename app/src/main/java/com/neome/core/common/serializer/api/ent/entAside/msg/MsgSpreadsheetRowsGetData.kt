package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.ent.entAside.msg.MsgSpreadsheetRowsGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowsGetData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val ascOrder: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val dateFieldId: Types.MetaIdField? = null,
    override val filterValue: SpreadsheetFilterComposite? = null,
    @Serializable(with = MetaIdFieldSer::class) override val groupByFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val inputFormCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    override val inputFormValueRaw: FormValueRaw? = null,
    override val searchText: String? = null,
    override val sortByFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet
) : MsgSpreadsheetRowsGet
