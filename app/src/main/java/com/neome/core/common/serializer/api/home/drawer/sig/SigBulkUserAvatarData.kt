package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.drawer.sig.SigBulkUserAvatar
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.home.drawer.sig.SigUserAvatarData
import com.neome.core.common.serializer.api.meta.base.dto.EnvValidationErrorData
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigBulkUserAvatarData(
    override val errorMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, EnvValidationErrorData>? = null,
    override val resultMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, SigUserAvatarData>? = null
) : SigBulkUserAvatar
