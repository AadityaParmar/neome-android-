package com.neome.core.common.serializer.api.core.otp.msg

import com.neome.api.core.otp.msg.MsgOtpVerify
import com.neome.api.meta.base.AnyKey
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.AnyKeySer
import com.neome.core.common.serializer.sysId.AnyOtpValueSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgOtpVerifyData(
    @Serializable(with = AnyOtpValueSer::class) override val otp: com.neome.api.nucleus.base.Types.AnyOtpValue,
    @Serializable(with = AnyKeySer::class) override val verifyKey: AnyKey
) : MsgOtpVerify
