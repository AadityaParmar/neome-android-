package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgSignInUserId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.UserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgSignInUserIdData(
    override val deviceName: String,
    override val deviceType: EnumDeviceType,
    override val password: String,
    override val rememberMe: Boolean,
    @Serializable(with = UserIdSer::class) override val userId: Types.UserId
) : MsgSignInUserId
