// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.EnumPaymentProviderKind

interface EntVdGeneratePaymentLink : EntVdAutoStepWithError {
    val allowedPaymentMethodSet: List<EnumDefnPaymentMethodKind>?
    val amount: StudioBuildArgBinder?
    val currency: StudioBuildArgBinder?
    val expiryDuration: StudioBuildArgBinder?
    val outputField: StudioDtoArgValueParameter?
    val paymentDescription: StudioBuildArgBinder?
    val paymentProvider: EnumPaymentProviderKind?
    val referenceIdField: StudioDtoArgValueParameter?
    val spreadsheetRowIdField: StudioDtoArgValueParameter?
}
