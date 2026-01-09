package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.home.main.sig.SigMessageBulk
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigMessageBulkData(
    override val errorMap: Map<Long, EnvValidationError>,
    override val messageMap: Map<Long, SigMessage>
) : SigMessageBulk
