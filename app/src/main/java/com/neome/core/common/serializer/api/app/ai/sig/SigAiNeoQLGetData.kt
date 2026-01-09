package com.neome.core.common.serializer.api.app.ai.sig

import com.neome.api.app.ai.sig.SigAiNeoQLGet
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigAiNeoQLGetData(
    override val error: Boolean,
    override val errorReason: String? = null,
    override val response: String? = null
) : SigAiNeoQLGet
