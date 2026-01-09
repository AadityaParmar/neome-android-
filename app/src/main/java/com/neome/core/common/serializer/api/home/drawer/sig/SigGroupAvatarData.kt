package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.drawer.sig.SigGroupAvatar
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class SigGroupAvatarData(
    override val version: String,
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    override val isAdmin: Boolean? = null,
    override val isMember: Boolean,
    override val label: String? = null,
    override val name: String
) : SigGroupAvatar
