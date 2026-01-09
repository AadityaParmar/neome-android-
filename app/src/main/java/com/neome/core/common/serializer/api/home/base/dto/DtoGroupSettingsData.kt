package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupSettings
import kotlinx.serialization.Serializable


@Serializable
data class DtoGroupSettingsData(
    override val anyOneCanJoin: Boolean,
    override val onlyAdminCanSendMessages: Boolean,
    override val onlyAdminCanUpdateGroupInfo: Boolean
) : DtoGroupSettings
