package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldSetOfOptionId
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfOptionIdData(
    override val displaySet: List<String>? = null,
    override val valueSet: List<String>
) : FieldSetOfOptionId
