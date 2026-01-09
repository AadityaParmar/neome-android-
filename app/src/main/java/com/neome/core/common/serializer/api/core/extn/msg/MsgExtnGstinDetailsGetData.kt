package com.neome.core.common.serializer.api.core.extn.msg

import com.neome.api.core.extn.msg.MsgExtnGstinDetailsGet
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgExtnGstinDetailsGetData(
    override val action: String? = null,
    override val gstin: String
) : MsgExtnGstinDetailsGet
