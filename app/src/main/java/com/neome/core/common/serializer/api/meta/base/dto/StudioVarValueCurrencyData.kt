package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVarValueCurrency
import com.neome.core.common.serializer.sysId.CurrencyKeySer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueCurrencyData(
    @Serializable(with = CurrencyKeySer::class) override val value: Types.CurrencyKey
) : StudioVarValueCurrency
