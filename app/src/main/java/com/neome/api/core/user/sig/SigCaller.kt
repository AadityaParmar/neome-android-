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
import java.util.Map

open class SigCaller : SigVersion() {
    var about: String? = null
    var allowCluster: Boolean? = null
    var allowStorePublish: Boolean? = null
    var allowStudio: Boolean? = null
    var chatNotificationSettingMap: Map<EntId, DtoEntChatNotificationSetting>? = null
    lateinit var creationTime: String
    lateinit var entAdminIdMap: Map<EntId, AdminId>
    lateinit var entUserIdMap: Map<EntId, EntUserId>
    var enterIsSendDesktop: Boolean? = null
    var enterIsSendMobile: Boolean? = null
    var firstName: String? = null
    var fromCache: Boolean? = null
    var globalNotificationSetting: DtoNotificationSetting? = null
    lateinit var groupIdSet: Array<GroupId>
    var handle: String? = null
    var languageKey: LanguageKey? = null
    var lastName: String? = null
    lateinit var lastUpdate: String
    var mediaIdAvatar: MediaIdAvatar? = null
    lateinit var pluginAdminIdMap: Map<PluginBundleId, AdminId>
    var resetPassword: Boolean? = null
    lateinit var storeItemAdminIdMap: Map<StoreItemId, AdminId>
    var updateProfile: Boolean? = null
    lateinit var userId: UserId
    lateinit var userIdHash: String
}
