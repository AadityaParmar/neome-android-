package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.user.sig.SigAppVersion
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigAppVersionData(
    override val currVersionCode: Long? = null,
    override val hasForceUpdate: Boolean,
    override val hasUpdate: Boolean,
    override val mmkvVersion: Long? = null,
    override val sqlVersion: Long? = null
) : SigAppVersion
