package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.MobileNumber
import com.neome.api.meta.base.dto.StudioVarValueMobileNumber
import com.neome.core.common.serializer.api.meta.base.dto.MobileNumberData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueMobileNumberData(
    override val value: MobileNumberData? = null
) : StudioVarValueMobileNumber
