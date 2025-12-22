// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethod
import com.neome.api.meta.base.Types.EnumDefnPaymentPlan

class StudioEntDeployPayment : StudioBase() {
    var communityMemId: string? = null
    var currency: string? = null
    var currentPlan: EnumDefnPaymentPlan? = null
    var freeTrialDate: string? = null
    var maximumMessagesPerMonth: number? = null
    var messagesPerSecond: number? = null
    var paymentGatewayToken: string? = null
    var paymentMethod: EnumDefnPaymentMethod? = null
    var totalPricePerMonth: number? = null
    var totalStorageGB: number? = null
}
