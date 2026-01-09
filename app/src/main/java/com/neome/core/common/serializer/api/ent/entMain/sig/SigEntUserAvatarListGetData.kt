package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.entMain.sig.SigEntUserAvatarListGet
import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntUserAvatarListGetData(
    override val version: String,
    override val avatarMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, SigUserAvatar>
) : SigEntUserAvatarListGet
