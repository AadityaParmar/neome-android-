package com.neome.core.common.serializer.api.ent.ent.sig

import com.neome.api.ent.ent.sig.SigEntSpreadsheetState
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigEntSpreadsheetStateData(
    override val gridRemoveVer: String,
    override val gridVer: String,
    override val rowCountVer: String,
    override val rowOrderVer: String,
    override val sheetIdHash: String
) : SigEntSpreadsheetState
