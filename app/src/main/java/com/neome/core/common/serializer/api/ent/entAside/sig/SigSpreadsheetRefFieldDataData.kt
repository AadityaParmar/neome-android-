package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigSpreadsheetRefFieldData
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRefFieldDataData(
    override val version: String,
    override val outputForm: DefnForm,
    override val rowList: Array<SigSpreadsheetRow>,
    override val spreadSheetLayoutMap: DefnLayoutGridMap? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : SigSpreadsheetRefFieldData
