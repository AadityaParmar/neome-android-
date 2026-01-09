package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindTranslation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntTranslation
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MetaIdTranslationSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntTranslationData(
    override val doNotShareWithPublicLibrary: Boolean? = null,
    @Serializable(with = MetaIdTranslationSer::class) override val metaId: Types.MetaIdTranslation,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val phrase: String,
    override val translationMap: Map<@Serializable(with = LanguageKeySer::class) Types.LanguageKey, String>? = null,
    override val type: EnumDefnKindTranslation
) : StudioEntTranslation
