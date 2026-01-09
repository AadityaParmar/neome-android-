package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.base.dto.DtoEntChatNotificationSetting
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.core.user.sig.SigCaller
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.GroupIdSer
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.PluginBundleIdSer
import com.neome.core.common.serializer.sysId.StoreItemIdSer
import com.neome.core.common.serializer.sysId.UserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigCallerData(
    override val version: String,
    override val about: String? = null,
    override val allowCluster: Boolean? = null,
    override val allowStorePublish: Boolean? = null,
    override val allowStudio: Boolean? = null,
    override val chatNotificationSettingMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, DtoEntChatNotificationSetting>? = null,
    override val creationTime: String,
    override val entAdminIdMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, @Serializable(with = AdminIdSer::class) Types.AdminId>,
    override val entUserIdMap: Map<@Serializable(with = EntIdSer::class) Types.EntId, @Serializable(with = EntUserIdSer::class) Types.EntUserId>,
    override val enterIsSendDesktop: Boolean? = null,
    override val enterIsSendMobile: Boolean? = null,
    override val firstName: String? = null,
    override val fromCache: Boolean? = null,
    override val globalNotificationSetting: DtoNotificationSetting? = null,
    override val groupIdSet: Array<@Serializable(with = GroupIdSer::class) Types.GroupId>,
    override val handle: String? = null,
    @Serializable(with = LanguageKeySer::class) override val languageKey: Types.LanguageKey? = null,
    override val lastName: String? = null,
    override val lastUpdate: String,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val pluginAdminIdMap: Map<@Serializable(with = PluginBundleIdSer::class) Types.PluginBundleId, @Serializable(with = AdminIdSer::class) Types.AdminId>,
    override val resetPassword: Boolean? = null,
    override val storeItemAdminIdMap: Map<@Serializable(with = StoreItemIdSer::class) Types.StoreItemId, @Serializable(with = AdminIdSer::class) Types.AdminId>,
    override val updateProfile: Boolean? = null,
    @Serializable(with = UserIdSer::class) override val userId: Types.UserId,
    override val userIdHash: String
) : SigCaller
