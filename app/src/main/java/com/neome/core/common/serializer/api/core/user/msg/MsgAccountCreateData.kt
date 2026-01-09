package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.core.user.msg.MsgAccountCreate
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.core.common.serializer.sysId.LanguageKeySer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAccountCreateData(
    override val handle: String,
    override val deviceName: String,
    override val deviceType: EnumDeviceType,
    override val firstName: String,
    @Serializable(with = LanguageKeySer::class) override val languageKey: Types.LanguageKey? = null,
    override val lastName: String,
    override val newPassword: String
) : MsgAccountCreate
