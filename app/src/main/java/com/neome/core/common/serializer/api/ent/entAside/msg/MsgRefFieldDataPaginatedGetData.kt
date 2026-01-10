package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.ent.entAside.msg.MsgRefFieldDataPaginatedGet
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.ent.base.dto.SpreadsheetFilterCompositeData
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgRefFieldDataPaginatedGetData(
    override val ascOrder: Boolean? = null,
    override val filterValue: SpreadsheetFilterCompositeData? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    override val includeFilters: Boolean? = null,
    @Serializable(with = MetaIdCompositeSer::class) override val inputFormCompositeId: Types.MetaIdComposite? = null,
    @Serializable(with = RowIdSer::class) override val inputFormGridRowId: Types.RowId? = null,
    override val inputFormValueRaw: FormValueRawData,
    @Serializable(with = MetaIdLayoutGridSer::class) override val layoutSpreadsheetId: Types.MetaIdLayoutGrid? = null,
    @Serializable(with = MetaIdFieldSer::class) override val orderByFieldId: Types.MetaIdField? = null,
    override val pageNumber: Long? = null,
    override val pageSize: Long? = null,
    @Serializable(with = MetaIdCompSer::class) override val refFieldId: Types.MetaIdComp,
    override val searchText: String? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val targetSpreadsheetId: Types.MetaIdSpreadsheet? = null
) : MsgRefFieldDataPaginatedGet
