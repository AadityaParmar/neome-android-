package com.neome.core.common.serializer.api.core.otp.msg

import com.neome.api.core.otp.msg.MsgQrCodeVerify
import com.neome.api.meta.base.AnyKey
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.AnyKeySer
import kotlinx.serialization.Serializable


@Serializable
data class MsgQrCodeVerifyData(
    @Serializable(with = AnyKeySer::class) override val verifyKey: AnyKey
) : MsgQrCodeVerify
