package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.user.sig.SigUserSetting
import com.neome.api.nucleus.base.sig.SigVersion
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class SigUserSettingData(
    override val version: String,
    override val userSetting: JsonElement? = null
) : SigUserSetting
