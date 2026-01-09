package com.neome.core.common.serializer.api.nucleus.base.msg

import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.nucleus.base.msg.MsgMediaRequest
import com.neome.core.common.serializer.sysId.DeviceIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdSer
import com.neome.core.common.serializer.sysId.RequestIdSer
import com.neome.core.common.serializer.sysId.UserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMediaRequestData(
    @Serializable(with = DeviceIdSer::class) override val callerDeviceId: Types.DeviceId? = null,
    @Serializable(with = UserIdSer::class) override val callerId: Types.UserId? = null,
    override val cmd: String? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null,
    override val expiry: Long? = null,
    override val fileName: String? = null,
    override val length: Long? = null,
    @Serializable(with = MediaIdSer::class) override val mediaId: Types.MediaId? = null,
    override val offset: Long? = null,
    @Serializable(with = RequestIdSer::class) override val requestId: Types.RequestId? = null
) : MsgMediaRequest
