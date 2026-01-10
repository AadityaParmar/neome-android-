package com.neome.core.common.serializer.api.ent.entAside.sig

import com.neome.api.ent.base.dto.DtoEntUserAvatar
import com.neome.api.ent.entAside.sig.SigEntInfo
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.ent.base.dto.DtoEntUserAvatarData
import com.neome.core.common.serializer.sysId.DemoAppIdSer
import com.neome.core.common.serializer.sysId.LanguageKeySer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class SigEntInfoData(
    override val version: String,
    override val about: String,
    @Serializable(with = MediaIdAvatarSer::class) override val avatarId: Types.MediaIdAvatar? = null,
    @Serializable(with = DemoAppIdSer::class) override val demoAppId: Types.DemoAppId,
    override val entUserAvatarList: List<DtoEntUserAvatarData>? = null,
    override val languageSet: List<@Serializable(with = LanguageKeySer::class) Types.LanguageKey>? = null,
    override val name: String,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey
) : SigEntInfo
