package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntDeploy
import com.neome.api.ent.base.dto.DtoVarUserSetting
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntDeployData(
    override val avatar: SigEntAvatarUser,
    override val roleMap: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, StudioEntRole>,
    override val userSettingVarMap: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, DtoVarUserSetting>
) : DtoEntDeploy
