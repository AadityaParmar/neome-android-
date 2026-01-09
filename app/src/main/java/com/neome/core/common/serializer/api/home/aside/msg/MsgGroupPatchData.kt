package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.aside.msg.MsgGroupPatch
import com.neome.api.home.base.Types.EnumGroupPatchPropName
import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupPatchData(
    override val version: String? = null,
    override val about: String? = null,
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val name: String? = null,
    override val patchPropNameSet: Array<EnumGroupPatchPropName>,
    override val settings: DtoGroupSettings? = null
) : MsgGroupPatch
