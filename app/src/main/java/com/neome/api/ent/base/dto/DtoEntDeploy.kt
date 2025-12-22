// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntRole

class DtoEntDeploy {
    val avatar: SigEntAvatarUser
    val roleMap: Record<MetaIdRole, StudioEntRole>
    val userSettingVarMap: Record<MetaIdVar, DtoVarUserSetting>
}
