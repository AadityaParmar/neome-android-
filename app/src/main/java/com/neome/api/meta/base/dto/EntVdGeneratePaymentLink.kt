// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.EnumPaymentProviderKind

class EntVdGeneratePaymentLink : EntVdAutoStepWithError() {
    var allowedPaymentMethodSet: EnumDefnPaymentMethodKind[]? = null
    var amount: StudioBuildArgBinder? = null
    var currency: StudioBuildArgBinder? = null
    var expiryDuration: StudioBuildArgBinder? = null
    var outputField: StudioDtoArgValueParameter? = null
    var paymentDescription: StudioBuildArgBinder? = null
    var paymentProvider: EnumPaymentProviderKind? = null
    var referenceIdField: StudioDtoArgValueParameter? = null
    var spreadsheetRowIdField: StudioDtoArgValueParameter? = null
}
