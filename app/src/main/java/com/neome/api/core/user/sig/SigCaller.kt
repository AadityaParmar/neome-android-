// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.core.base.dto.DtoEntChatNotificationSetting
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.LanguageKey
import java.util.Map
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId
import java.util.Set
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.Types.StoreItemId
import com.neome.api.meta.base.Types.UserId

interface SigCaller : SigVersion
{
  val about: String?
  val allowCluster: Boolean?
  val allowStorePublish: Boolean?
  val allowStudio: Boolean?
  val chatNotificationSettingMap: Map<EntId, DtoEntChatNotificationSetting>?
  val creationTime: String
  val entAdminIdMap: Map<EntId, AdminId>
  val entUserIdMap: Map<EntId, EntUserId>
  val enterIsSendDesktop: Boolean?
  val enterIsSendMobile: Boolean?
  val firstName: String?
  val fromCache: Boolean?
  val globalNotificationSetting: DtoNotificationSetting?
  val groupIdSet: Array<GroupId>
  val handle: String?
  val languageKey: LanguageKey?
  val lastName: String?
  val lastUpdate: String
  val mediaIdAvatar: MediaIdAvatar?
  val pluginAdminIdMap: Map<PluginBundleId, AdminId>
  val resetPassword: Boolean?
  val storeItemAdminIdMap: Map<StoreItemId, AdminId>
  val updateProfile: Boolean?
  val userId: UserId
  val userIdHash: String
}