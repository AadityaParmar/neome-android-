package com.neome.core.common.serializer.api.ent.agent.sig

import com.neome.api.ent.agent.sig.SigAgentEntUserImport
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import com.neome.core.common.serializer.sysId.HandleKeySer
import kotlinx.serialization.Serializable


@Serializable
data class SigAgentEntUserImportData(
    override val errorMap: Map<@Serializable(with = HandleKeySer::class) Types.HandleKey, EnvValidationErrorData>
) : SigAgentEntUserImport
