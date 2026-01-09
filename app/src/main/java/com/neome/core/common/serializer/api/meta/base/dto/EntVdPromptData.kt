package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdPrompt
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.core.common.serializer.sysId.GhostIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdPromptData(
    @Serializable(with = GhostIdSer::class) override val metaId: Types.GhostId,
    override val prompt: StudioValueCodeJavascript? = null,
    override val promptForm: FormRefKey? = null
) : EntVdPrompt
