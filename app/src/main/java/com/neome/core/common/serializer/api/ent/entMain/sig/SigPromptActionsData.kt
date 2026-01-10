package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoPromptAction
import com.neome.api.ent.entMain.sig.SigPromptActions
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoPromptActionData
import kotlinx.serialization.Serializable


@Serializable
data class SigPromptActionsData(
    override val executedPromptActionList: List<DtoPromptActionData>? = null,
    override val reviewPromptActionList: List<DtoPromptActionData>? = null
) : SigPromptActions
