package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigUserLastOnline
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigUserLastOnlineData(
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val lastOnline: String? = null,
    override val online: Boolean? = null
) : SigUserLastOnline
