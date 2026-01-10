package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoEntUserInfo
import com.neome.api.ent.entMain.sig.SigUserActionResult
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntUserInfoData
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigUserActionResultData(
    override val userMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoEntUserInfoData>
) : SigUserActionResult
