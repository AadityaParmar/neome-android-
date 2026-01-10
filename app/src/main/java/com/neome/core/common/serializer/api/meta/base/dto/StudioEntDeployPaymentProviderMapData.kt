package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployPaymentProviderMap
import com.neome.api.meta.base.dto.StudioEntPaymentProvider
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPaymentProviderData
import com.neome.core.common.serializer.sysId.MetaIdPaymentProviderSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeployPaymentProviderMapData(
    @Serializable(with = MetaIdPaymentProviderSer::class) override val defaultPaymentProviderId: Types.MetaIdPaymentProvider? = null,
    override val keys: List<@Serializable(with = MetaIdPaymentProviderSer::class) Types.MetaIdPaymentProvider>,
    override val map: Map<@Serializable(with = MetaIdPaymentProviderSer::class) Types.MetaIdPaymentProvider, StudioEntPaymentProviderData>
) : StudioEntDeployPaymentProviderMap
