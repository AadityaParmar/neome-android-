package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoDeeplinkAvatar
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoDeeplinkAvatarData(
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val name: String? = null
) : DtoDeeplinkAvatar
