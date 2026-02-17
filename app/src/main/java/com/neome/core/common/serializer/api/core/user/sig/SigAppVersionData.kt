package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.user.sig.SigAppVersion
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigAppVersionData(
    override val currVersionCode: Long,
    override val hasForceUpdate: Boolean,
    override val hasUpdate: Boolean,
    override val mmkvVersion: Long,
    override val sqlVersion: Long
) : SigAppVersion
