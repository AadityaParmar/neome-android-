// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.core.base.dto.DtoEntChatNotificationSetting
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.Types.UserId
import com.neome.api.nucleus.base.sig.SigVersion

class SigCaller : SigVersion() {
    var about: string? = null
    var allowCluster: boolean? = null
    var allowStorePublish: boolean? = null
    var allowStudio: boolean? = null
    var chatNotificationSettingMap: Record<EntId, DtoEntChatNotificationSetting>? = null
    val creationTime: string
    val entAdminIdMap: Record<EntId, AdminId>
    val entUserIdMap: Record<EntId, EntUserId>
    var enterIsSendDesktop: boolean? = null
    var enterIsSendMobile: boolean? = null
    var firstName: string? = null
    var fromCache: boolean? = null
    var globalNotificationSetting: DtoNotificationSetting? = null
    val groupIdSet: GroupId[]
    var handle: string? = null
    var languageKey: LanguageKey? = null
    var lastName: string? = null
    val lastUpdate: string
    var mediaIdAvatar: MediaIdAvatar? = null
    val pluginAdminIdMap: Record<PluginBundleId, AdminId>
    var resetPassword: boolean? = null
    val storeItemAdminIdMap: Record<StoreItemId, AdminId>
    var updateProfile: boolean? = null
    val userId: UserId
    val userIdHash: string
}
