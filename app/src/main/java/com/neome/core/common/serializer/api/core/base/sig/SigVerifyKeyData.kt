package com.neome.core.common.serializer.api.core.base.sig

import com.neome.api.core.base.sig.SigVerifyKey
import com.neome.api.meta.base.AnyKey
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.AnyKeySer
import kotlinx.serialization.Serializable


@Serializable
data class SigVerifyKeyData(
    override val expiryMins: Long,
    @Serializable(with = AnyKeySer::class) override val verifyKey: AnyKey
) : SigVerifyKey
