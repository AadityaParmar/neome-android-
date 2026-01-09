package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntPrompt
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdPromptSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntPromptData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val description: String? = null,
    override val hint: String? = null,
    @Serializable(with = MetaIdPromptSer::class) override val metaId: Types.MetaIdPrompt,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : DtoEntPrompt
