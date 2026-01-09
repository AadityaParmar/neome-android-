package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoPaymentProvider
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumPaymentProviderKind
import com.neome.core.common.serializer.sysId.MetaIdPaymentProviderSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoPaymentProviderData(
    override val kind: EnumPaymentProviderKind,
    @Serializable(with = MetaIdPaymentProviderSer::class) override val metaId: Types.MetaIdPaymentProvider
) : DtoPaymentProvider
