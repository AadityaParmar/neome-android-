package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntTranslation
import com.neome.api.meta.base.dto.StudioEntTranslationMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntTranslationData
import com.neome.core.common.serializer.sysId.MetaIdTranslationSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntTranslationMapData(
    override val keys: List<@Serializable(with = MetaIdTranslationSer::class) Types.MetaIdTranslation>,
    override val map: Map<@Serializable(with = MetaIdTranslationSer::class) Types.MetaIdTranslation, StudioEntTranslationData>,
    override val usePublicLibrary: Boolean? = null
) : StudioEntTranslationMap
