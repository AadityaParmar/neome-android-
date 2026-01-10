package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioEntGroup
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.core.common.serializer.api.meta.base.dto.StudioDetailsData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfActionPermissionData
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntGroupData(
    override val actionPermissionMap: StudioMapOfActionPermissionData? = null,
    override val allowPromptAssistant: Boolean? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    override val chatPermissionSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = MetaIdActionSer::class) override val defaultActionId: Types.MetaIdAction? = null,
    override val details: StudioDetailsData,
    override val freeze: Boolean? = null,
    override val freezeAvatarKind: EnumDefnFreezeAvatarKind? = null,
    override val freezeSortName: String? = null,
    override val groupPermissionSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val hideActionMenu: Boolean? = null,
    override val hideMembers: Boolean? = null,
    @Serializable(with = MetaIdGroupSer::class) override val metaId: Types.MetaIdGroup,
    override val pinnedActionIdSet: List<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>? = null,
    override val pinnedActionIdSetMobile: List<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>? = null,
    override val removeMessagePermissionSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null
) : StudioEntGroup
