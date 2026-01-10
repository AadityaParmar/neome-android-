package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldSetOfString
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfStringData(
    override val valueSet: List<String>
) : FieldSetOfString
