package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy
import com.neome.api.meta.base.Types.EnumDefnStoreItem
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDetails
import com.neome.api.meta.base.dto.StudioEntWallpaper
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntWallpaperData
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDetailsData(
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    override val displayDateFormat: String? = null,
    override val hideAddressBook: Boolean? = null,
    override val languageSet: List<@Serializable(with = LanguageKeySer::class) Types.LanguageKey>? = null,
    override val locationAccuracy: EnumDefnLocationAccuracy? = null,
    override val name: String,
    override val storeAbout: String? = null,
    override val storeItemType: EnumDefnStoreItem? = null,
    override val storeLabelSet: List<EnumStoreLabel>? = null,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey? = null,
    override val wallpaper: StudioEntWallpaperData? = null
) : StudioEntDetails
