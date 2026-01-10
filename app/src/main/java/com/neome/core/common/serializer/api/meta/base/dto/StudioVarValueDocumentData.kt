package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoDocument
import com.neome.api.meta.base.dto.StudioVarValueDocument
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoDocumentData
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueDocumentData(
    override val value: FieldDtoDocumentData
) : StudioVarValueDocument
