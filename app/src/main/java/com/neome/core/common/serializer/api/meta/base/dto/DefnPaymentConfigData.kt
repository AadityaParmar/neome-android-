package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.dto.DefnPaymentConfig
import com.neome.core.common.serializer.sysId.CurrencyKeySer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnPaymentConfigData(
    override val allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val amountFieldId: Types.MetaIdField? = null,
    @Serializable(with = CurrencyKeySer::class) override val currency: Types.CurrencyKey? = null,
    @Serializable(with = MetaIdFieldSer::class) override val currencyFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val customerContactFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val customerEmailFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val customerNameFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdFieldSer::class) override val descriptionFieldId: Types.MetaIdField? = null,
    override val enablePayment: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val referenceIdFieldId: Types.MetaIdField? = null
) : DefnPaymentConfig
