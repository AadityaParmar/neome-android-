package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPaymentProvider
import com.neome.core.common.serializer.sysId.MetaIdPaymentProviderSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPaymentProviderData(
    override val kind: EnumPaymentProviderKind,
    @Serializable(with = MetaIdPaymentProviderSer::class) override val metaId: Types.MetaIdPaymentProvider,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null
) : StudioEntPaymentProvider
