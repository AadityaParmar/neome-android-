package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.dto.FieldChipSetDeviceType
import kotlinx.serialization.Serializable


@Serializable
data class FieldChipSetDeviceTypeData(
    override val valueSet: List<EnumDeviceType>
) : FieldChipSetDeviceType
