// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.MetaIdField

interface StudioPaymentConfig : StudioBase {
    val allowedPaymentMethodSet: List<EnumDefnPaymentMethodKind>?
    val amountFieldId: MetaIdField?
    val currency: CurrencyKey?
    val currencyFieldId: MetaIdField?
    val customerContactFieldId: MetaIdField?
    val customerEmailFieldId: MetaIdField?
    val customerNameFieldId: MetaIdField?
    val descriptionFieldId: MetaIdField?
    val enablePayment: Boolean?
    val referenceIdFieldId: MetaIdField?
}
