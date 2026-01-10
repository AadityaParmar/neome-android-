package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoFieldFilter
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoFieldFilterData
import com.neome.core.common.serializer.api.home.main.sig.SigSpreadsheetRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.core.common.serializer.api.meta.base.dto.DefnLayoutGridMapData
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowsPageData(
    override val filterList: List<DtoFieldFilterData>,
    override val hasMoreRows: Boolean,
    override val outputForm: DefnFormData,
    override val rowList: List<SigSpreadsheetRowData>,
    override val spreadSheetLayoutMap: DefnLayoutGridMapData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : SigSpreadsheetRowsPage
