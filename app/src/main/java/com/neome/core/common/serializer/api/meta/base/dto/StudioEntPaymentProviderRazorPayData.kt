package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPaymentMethodKind
import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.api.meta.base.dto.StudioEntPaymentProvider
import com.neome.api.meta.base.dto.StudioEntPaymentProviderRazorPay
import com.neome.core.common.serializer.sysId.CurrencyKeySer
import com.neome.core.common.serializer.sysId.MetaIdPaymentProviderSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPaymentProviderRazorPayData(
    override val kind: EnumPaymentProviderKind,
    @Serializable(with = MetaIdPaymentProviderSer::class) override val metaId: Types.MetaIdPaymentProvider,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val allowedPaymentMethodSet: List<EnumDefnPaymentMethodKind>? = null,
    override val apiKey: String? = null,
    override val apiSecret: String? = null,
    @Serializable(with = CurrencyKeySer::class) override val defaultCurrency: Types.CurrencyKey? = null,
    override val webhookSecret: String? = null
) : StudioEntPaymentProviderRazorPay
