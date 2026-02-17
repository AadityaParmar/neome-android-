// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethod
import com.neome.api.meta.base.Types.EnumDefnPaymentPlan
import com.neome.api.meta.base.dto.StudioBase

interface StudioEntDeployPayment : StudioBase
{
  val communityMemId: String?
  val currency: String?
  val currentPlan: EnumDefnPaymentPlan?
  val freeTrialDate: String?
  val maximumMessagesPerMonth: Long?
  val messagesPerSecond: Long?
  val paymentGatewayToken: String?
  val paymentMethod: EnumDefnPaymentMethod?
  val totalPricePerMonth: Double?
  val totalStorageGB: Long?
}