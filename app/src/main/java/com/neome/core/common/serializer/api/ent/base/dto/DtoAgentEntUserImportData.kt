package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAgentEntUserImport
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoAgentEntUserImportData(
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String,
    @Serializable(with = EntUserIdSer::class) override val managerId: Types.EntUserId? = null,
    override val nickName: String,
    override val roleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val userVariableValueMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, JsonElement>? = null
) : DtoAgentEntUserImport
