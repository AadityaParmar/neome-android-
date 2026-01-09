package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoPaymentProvider
import com.neome.api.ent.base.dto.DtoPaymentProviderRazorpay
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.core.common.serializer.sysId.CurrencyKeySer
import com.neome.core.common.serializer.sysId.MetaIdPaymentProviderSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPaymentProviderRazorpayData(
    override val kind: EnumPaymentProviderKind,
    @Serializable(with = MetaIdPaymentProviderSer::class) override val metaId: Types.MetaIdPaymentProvider,
    override val allowedPaymentMethodSet: Array<EnumDefnPaymentMethodKind>? = null,
    override val apiKey: String,
    @Serializable(with = CurrencyKeySer::class) override val defaultCurrency: Types.CurrencyKey
) : DtoPaymentProviderRazorpay
