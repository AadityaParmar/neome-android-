package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DtoDeeplinkWebPreview
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoDeeplinkWebPreviewData(
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    override val deeplinkActionType: EnumDeeplinkActionType? = null,
    override val desc: String? = null,
    override val info: String? = null,
    override val senderName: String? = null,
    override val targetName: String? = null,
    override val title: String? = null
) : DtoDeeplinkWebPreview
