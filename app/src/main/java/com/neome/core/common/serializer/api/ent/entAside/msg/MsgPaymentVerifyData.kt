package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgPaymentVerify
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgPaymentVerifyData(
    override val invoiceId: String,
    override val paymentId: String,
    override val signature: String
) : MsgPaymentVerify
