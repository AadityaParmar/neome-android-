package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoPromptAction
import com.neome.api.ent.entMain.sig.SigPromptActions
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigPromptActionsData(
    override val executedPromptActionList: Array<DtoPromptAction>? = null,
    override val reviewPromptActionList: Array<DtoPromptAction>? = null
) : SigPromptActions
