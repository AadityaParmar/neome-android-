package com.neome.core.common.serializer.api.core.task.sig

import com.neome.api.core.base.Types.EnumTaskStatus
import com.neome.api.core.task.sig.SigTask
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class SigTaskData(
    override val error: EnvValidationError? = null,
    override val progress: Long? = null,
    override val result: JsonElement? = null,
    override val status: EnumTaskStatus
) : SigTask
