package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigSpreadsheetRowExpiry
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowExpiryData(
    override val remainingInvisibleProgressPercentage: Long? = null,
    override val remainingInvisibleTimeMillis: Long? = null,
    override val remainingReadProgressPercentage: Long? = null,
    override val remainingReadTimeMillis: Long? = null,
    override val showTimer: Boolean? = null
) : SigSpreadsheetRowExpiry
