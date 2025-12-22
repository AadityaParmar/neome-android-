// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.sig

import com.neome.api.home.base.dto.DtoGroupMemberMetaData
import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.base.dto.DtoUserGroupConfiguration
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.sig.SigVersion

class SigGroupInfo : SigVersion() {
    val about: string
    val adminMap: Record<EntUserId, DtoGroupMemberMetaData>
    var allowPromptAssistant: boolean? = null
    var avatarId: MediaIdAvatar? = null
    val entId: EntId
    val groupConfiguration: DtoUserGroupConfiguration
    val groupId: GroupId
    var label: string? = null
    val memberMap: Record<EntUserId, DtoGroupMemberMetaData>
    val name: string
    val settings: DtoGroupSettings
}
