// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnPaymentMethod
import com.neome.api.meta.base.Types.EnumDefnPaymentPlan
import com.neome.api.meta.base.dto.StudioBase

open class StudioEntDeployPayment : StudioBase()
{
  var communityMemId: String? = null
  var currency: String? = null
  var currentPlan: EnumDefnPaymentPlan? = null
  var freeTrialDate: String? = null
  var maximumMessagesPerMonth: Number? = null
  var messagesPerSecond: Number? = null
  var paymentGatewayToken: String? = null
  var paymentMethod: EnumDefnPaymentMethod? = null
  var totalPricePerMonth: Number? = null
  var totalStorageGB: Number? = null
}