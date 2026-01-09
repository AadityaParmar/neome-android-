package com.neome.core.common.serializer.api.ent.entDrawer.sig

import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntAvatarUserData(
    override val version: String,
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val name: String
) : SigEntAvatarUser
