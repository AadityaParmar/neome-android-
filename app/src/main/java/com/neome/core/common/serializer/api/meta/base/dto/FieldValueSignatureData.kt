package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueLocation
import com.neome.api.meta.base.dto.FieldValueSignature
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueSignatureData(
    override val captureLocation: FieldValueLocation? = null,
    override val captureTime: String? = null,
    override val captureUser: FieldValueEntUserId? = null,
    override val handle: String,
    override val signature: String
) : FieldValueSignature
