package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.ent.entMain.msg.MsgSpreadsheetRowsPageGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.ent.base.dto.SpreadsheetFilterCompositeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSpreadsheetRowsPageGetData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val ascOrder: Boolean? = null,
    override val filterValue: SpreadsheetFilterCompositeData? = null,
    override val includeFilters: Boolean? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val inputFormCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    override val inputFormValueRaw: FormValueRawData? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    @Serializable(with = MetaIdFieldSer::class) override val orderByFieldId: Types.MetaIdField? = null,
    override val pageNumber: Long? = null,
    override val pageSize: Long? = null,
    override val searchText: String? = null
) : MsgSpreadsheetRowsPageGet
