package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.nucleus.base.sig.SigVersion
import kotlinx.serialization.Serializable


@Serializable
data class SigSpreadsheetRowCommentCountData(
    override val version: String,
    override val commentCount: Long? = null,
    override val unreadCommentCount: Long? = null
) : SigSpreadsheetRowCommentCount
