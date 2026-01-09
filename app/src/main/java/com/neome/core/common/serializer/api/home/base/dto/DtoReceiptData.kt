package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoReceipt
import kotlinx.serialization.Serializable


@Serializable
data class DtoReceiptData(
    override val deliveredOn: String? = null,
    override val readOn: String? = null
) : DtoReceipt
