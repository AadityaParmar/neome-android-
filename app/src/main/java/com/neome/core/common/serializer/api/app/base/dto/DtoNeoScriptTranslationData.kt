package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptTranslation
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdTranslationSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptTranslationData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdTranslationSer::class) override val translationId: Types.MetaIdTranslation? = null
) : DtoNeoScriptTranslation
