// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole

class StudioEntGroup : StudioBase() {
    var actionPermissionMap: StudioMapOfActionPermission? = null
    var allowPromptAssistant: boolean? = null
    var avatarId: MediaIdAvatar? = null
    var chatPermissionSet: MetaIdRole[]? = null
    var defaultActionId: MetaIdAction? = null
    val details: StudioDetails
    var freeze: boolean? = null
    var freezeAvatarKind: EnumDefnFreezeAvatarKind? = null
    var freezeSortName: string? = null
    var groupPermissionSet: MetaIdRole[]? = null
    var hideActionMenu: boolean? = null
    var hideMembers: boolean? = null
    val metaId: MetaIdGroup
    var pinnedActionIdSet: MetaIdAction[]? = null
    var pinnedActionIdSetMobile: MetaIdAction[]? = null
    var removeMessagePermissionSet: MetaIdRole[]? = null
}
