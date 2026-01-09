package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.GsonCto
import com.neome.api.meta.base.dto.MobileNumber
import kotlinx.serialization.Serializable


@Serializable
data class MobileNumberData(
    override val countryCode: Long? = null,
    override val nationalNumber: Long? = null
) : MobileNumber
