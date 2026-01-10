package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueLocation
import com.neome.api.meta.base.dto.FieldValueSwitch
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueSwitchData(
    override val captureLocation: FieldValueLocationData? = null,
    override val captureTime: String? = null,
    override val captureUser: FieldValueEntUserIdData? = null,
    override val value: Boolean
) : FieldValueSwitch
