// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioMapOfActionPermission

open class StudioEntGroup : StudioBase()
{
  var actionPermissionMap: StudioMapOfActionPermission? = null
  var allowPromptAssistant: Boolean? = null
  var avatarId: MediaIdAvatar? = null
  var chatPermissionSet: Array<MetaIdRole>? = null
  var defaultActionId: MetaIdAction? = null
  lateinit var details: StudioDetails
  var freeze: Boolean? = null
  var freezeAvatarKind: EnumDefnFreezeAvatarKind? = null
  var freezeSortName: String? = null
  var groupPermissionSet: Array<MetaIdRole>? = null
  var hideActionMenu: Boolean? = null
  var hideMembers: Boolean? = null
  lateinit var metaId: MetaIdGroup
  var pinnedActionIdSet: Array<MetaIdAction>? = null
  var pinnedActionIdSetMobile: Array<MetaIdAction>? = null
  var removeMessagePermissionSet: Array<MetaIdRole>? = null
}