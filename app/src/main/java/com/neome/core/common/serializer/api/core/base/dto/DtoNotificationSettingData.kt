package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.dto.GsonCto
import kotlinx.serialization.Serializable


@Serializable
data class DtoNotificationSettingData(
    override val mute: Boolean? = null
) : DtoNotificationSetting
