package com.neome.core.common.serializer.api.core.deeplink.sig

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.core.base.dto.DtoDeeplinkWebPreview
import com.neome.api.core.deeplink.sig.SigDeeplinkData
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.ArtifactIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigDeeplinkDataData(
    @Serializable(with = ArtifactIdSer::class) override val artifactId: Types.ArtifactId,
    override val deeplinkActionType: EnumDeeplinkActionType,
    override val payload: DeeplinkDataPayload? = null,
    override val preview: DtoDeeplinkWebPreview? = null,
    override val requiredSignIn: Boolean
) : SigDeeplinkData
