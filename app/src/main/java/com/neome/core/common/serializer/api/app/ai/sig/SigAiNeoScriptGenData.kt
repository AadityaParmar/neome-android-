package com.neome.core.common.serializer.api.app.ai.sig

import com.neome.api.app.ai.sig.SigAiNeoScriptGen
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigAiNeoScriptGenData(
    override val error: String? = null,
    override val neoScripts: List<String>? = null,
    override val userMessage: String? = null
) : SigAiNeoScriptGen
