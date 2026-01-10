package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.home.drawer.msg.MsgCallerProfilePatch
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoNotificationSettingData
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerProfilePatchData(
    override val about: String? = null,
    override val enterIsSendDesktop: Boolean? = null,
    override val enterIsSendMobile: Boolean? = null,
    override val firstName: String,
    override val globalNotificationSetting: DtoNotificationSettingData? = null,
    @Serializable(with = LanguageKeySer::class) override val languageKey: Types.LanguageKey? = null,
    override val lastName: String,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null
) : MsgCallerProfilePatch
