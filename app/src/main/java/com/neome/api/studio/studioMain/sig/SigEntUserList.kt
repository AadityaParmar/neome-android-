// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.studio.base.dto.DtoEntUser
import com.neome.api.studio.base.dto.DtoStudioVarUserSettingWrapper

class SigEntUserList : SigVersion() {
    var deployedRoleSet: StudioEntRole[]? = null
    var deployedUserSettingSet: DtoStudioVarUserSettingWrapper[]? = null
    val entUserSet: DtoEntUser[]
}
