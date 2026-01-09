package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgContactUs
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgContactUsData(
    override val attrMap: Map<String, String>? = null,
    override val companyName: String? = null,
    override val content: String? = null,
    override val email: String? = null,
    override val fullName: String? = null,
    override val mobileNumber: String? = null,
    override val pageName: String? = null
) : MsgContactUs
