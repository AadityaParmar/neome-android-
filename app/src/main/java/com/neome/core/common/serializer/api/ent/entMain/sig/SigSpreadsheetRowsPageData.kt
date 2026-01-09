package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoFieldFilter
import com.neome.api.ent.entMain.sig.SigSpreadsheetRowsPage
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowsPageData(
    override val filterList: Array<DtoFieldFilter>,
    override val hasMoreRows: Boolean,
    override val outputForm: DefnForm,
    override val rowList: Array<SigSpreadsheetRow>,
    override val spreadSheetLayoutMap: DefnLayoutGridMap? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : SigSpreadsheetRowsPage
