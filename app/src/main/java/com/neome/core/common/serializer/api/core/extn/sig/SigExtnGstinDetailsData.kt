package com.neome.core.common.serializer.api.core.extn.sig

import com.neome.api.core.extn.sig.SigExtnGstinDetails
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class SigExtnGstinDetailsData(
    override val data: JsonElement? = null,
    override val errorCode: Long? = null,
    override val errorMessage: String? = null
) : SigExtnGstinDetails
