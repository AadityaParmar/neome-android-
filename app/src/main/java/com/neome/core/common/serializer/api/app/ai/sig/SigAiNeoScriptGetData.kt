package com.neome.core.common.serializer.api.app.ai.sig

import com.neome.api.app.ai.sig.SigAiNeoScriptGet
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigAiNeoScriptGetData(
    override val error: String? = null,
    override val neoScript: String? = null,
    override val userMessage: String? = null
) : SigAiNeoScriptGet
