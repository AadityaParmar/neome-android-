// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.CurrencyKey
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.MetaIdField

open class DefnPaymentConfig {
    var allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null
    var amountFieldId: MetaIdField? = null
    var currency: CurrencyKey? = null
    var currencyFieldId: MetaIdField? = null
    var customerContactFieldId: MetaIdField? = null
    var customerEmailFieldId: MetaIdField? = null
    var customerNameFieldId: MetaIdField? = null
    var descriptionFieldId: MetaIdField? = null
    var enablePayment: Boolean? = null
    var referenceIdFieldId: MetaIdField? = null
}
