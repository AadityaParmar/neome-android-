package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethod
import com.neome.api.meta.base.Types.EnumDefnPaymentPlan
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployPayment
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeployPaymentData(
    override val communityMemId: String? = null,
    override val currency: String? = null,
    override val currentPlan: EnumDefnPaymentPlan? = null,
    override val freeTrialDate: String? = null,
    override val maximumMessagesPerMonth: Long? = null,
    override val messagesPerSecond: Long? = null,
    override val paymentGatewayToken: String? = null,
    override val paymentMethod: EnumDefnPaymentMethod? = null,
    override val totalPricePerMonth: Long? = null,
    override val totalStorageGB: Long? = null
) : StudioEntDeployPayment
