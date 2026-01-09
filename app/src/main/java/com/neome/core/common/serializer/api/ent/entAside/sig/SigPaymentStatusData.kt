package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.entAside.sig.SigPaymentStatus
import com.neome.api.meta.base.Types.EnumDefnPaymentStatus
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigPaymentStatusData(
    override val paymentStatus: EnumDefnPaymentStatus
) : SigPaymentStatus
