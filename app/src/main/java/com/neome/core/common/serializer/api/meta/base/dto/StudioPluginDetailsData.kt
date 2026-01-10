package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDetails
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginDetailsData(
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    override val name: String,
    override val storeAbout: String? = null,
    override val storeLabelSet: List<EnumStoreLabel>? = null
) : StudioPluginDetails
