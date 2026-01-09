package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgAddressBookContact
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgAddressBookContactData(
    override val handle: String,
    override val nickName: String
) : MsgAddressBookContact
