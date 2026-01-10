package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgPluginApiResponse
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.dto.EnvError
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.core.common.serializer.api.nucleus.base.dto.EnvErrorData
import com.neome.core.common.serializer.sysId.RequestIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPluginApiResponseData(
    override val pluginError: EnvErrorData? = null,
    @Serializable(with = RequestIdSer::class) override val requestId: Types.RequestId,
    override val responseFormValue: FormValueRawData? = null
) : MsgPluginApiResponse
