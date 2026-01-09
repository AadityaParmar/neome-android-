package com.neome.core.common.serializer.api.ent.main.sig

import com.neome.api.ent.main.sig.SigTaskId
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigTaskIdData(
    override val taskId: String? = null
) : SigTaskId
