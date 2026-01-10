package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.dto.FieldValueCamera
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueImage
import com.neome.api.meta.base.dto.FieldValueLocation
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueCameraData(
    override val value: FieldDtoImageData,
    override val captureLocation: FieldValueLocationData? = null,
    override val captureTime: String? = null,
    override val captureUser: FieldValueEntUserIdData? = null
) : FieldValueCamera
