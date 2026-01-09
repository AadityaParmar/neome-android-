package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoPickerEntUser
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoPickerEntUserData(
    @Serializable(with = MediaIdSer::class) override val avatarId: Types.MediaId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val nickName: String,
    override val userSettingValueMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, JsonElement>? = null
) : DtoPickerEntUser
