package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigSpreadsheetRowsGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowsGetData(
    override val dateRowIdSetMap: Map<String, Set<@Serializable(with = RowIdSer::class) Types.RowId>>? = null,
    override val groupByRowIdSetMap: Map<String, Set<@Serializable(with = RowIdSer::class) Types.RowId>>? = null,
    @Serializable(with = MetaIdFormSer::class) override val outputFormId: Types.MetaIdForm,
    override val rowIdSet: List<@Serializable(with = RowIdSer::class) Types.RowId>? = null
) : SigSpreadsheetRowsGet
