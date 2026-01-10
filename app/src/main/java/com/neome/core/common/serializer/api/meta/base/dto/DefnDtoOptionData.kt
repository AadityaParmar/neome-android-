package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoOption
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoOptionData(
    override val color: DefnDtoColorData? = null,
    override val disabled: Boolean? = null,
    override val hint: String? = null,
    override val isRemoved: Boolean? = null,
    override val metaId: String,
    override val value: String
) : DefnDtoOption
