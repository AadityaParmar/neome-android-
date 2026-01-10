// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole

interface StudioEntGroup : StudioBase {
    val actionPermissionMap: StudioMapOfActionPermission?
    val allowPromptAssistant: Boolean?
    val avatarId: MediaIdAvatar?
    val chatPermissionSet: List<MetaIdRole>?
    val defaultActionId: MetaIdAction?
    val details: StudioDetails
    val freeze: Boolean?
    val freezeAvatarKind: EnumDefnFreezeAvatarKind?
    val freezeSortName: String?
    val groupPermissionSet: List<MetaIdRole>?
    val hideActionMenu: Boolean?
    val hideMembers: Boolean?
    val metaId: MetaIdGroup
    val pinnedActionIdSet: List<MetaIdAction>?
    val pinnedActionIdSetMobile: List<MetaIdAction>?
    val removeMessagePermissionSet: List<MetaIdRole>?
}
