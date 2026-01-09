package com.neome.core.common.serializer.api.home.aside.sig

import com.neome.api.home.aside.sig.SigMessageReceiptMap
import com.neome.api.home.base.dto.DtoReceipt
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigMessageReceiptMapData(
    override val entUserReceiptMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoReceipt>
) : SigMessageReceiptMap
