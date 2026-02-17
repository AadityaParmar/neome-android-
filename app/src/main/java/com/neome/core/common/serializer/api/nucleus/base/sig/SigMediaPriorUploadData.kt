package com.neome.core.common.serializer.api.nucleus.base.sig

import com.neome.api.nucleus.base.Types.EnumMediaExchangeStatus
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.nucleus.base.sig.SigMediaPriorUpload
import kotlinx.serialization.Serializable


@Serializable
data class SigMediaPriorUploadData(
    override val serverUploadLen: Long,
    override val serverUploadState: EnumMediaExchangeStatus
) : SigMediaPriorUpload
