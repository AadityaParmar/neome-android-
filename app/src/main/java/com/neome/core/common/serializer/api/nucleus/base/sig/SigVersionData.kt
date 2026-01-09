package com.neome.core.common.serializer.api.nucleus.base.sig

import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.nucleus.base.sig.SigVersion
import kotlinx.serialization.Serializable


@Serializable
data class SigVersionData(
    override val version: String
) : SigVersion
