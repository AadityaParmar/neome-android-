package com.neome.core.common.serializer.api.home.aside.sig

import com.neome.api.home.aside.sig.SigGroupInfo
import com.neome.api.home.base.dto.DtoGroupMemberMetaData
import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.base.dto.DtoUserGroupConfiguration
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class SigGroupInfoData(
    override val version: String,
    override val about: String,
    override val adminMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoGroupMemberMetaData>,
    override val allowPromptAssistant: Boolean? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val groupConfiguration: DtoUserGroupConfiguration,
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    override val label: String? = null,
    override val memberMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, DtoGroupMemberMetaData>,
    override val name: String,
    override val settings: DtoGroupSettings
) : SigGroupInfo
