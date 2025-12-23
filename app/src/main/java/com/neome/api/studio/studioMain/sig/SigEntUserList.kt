// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.studio.base.dto.DtoEntUser
import com.neome.api.studio.base.dto.DtoStudioVarUserSettingWrapper
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.dto.StudioEntRole

open class SigEntUserList : SigVersion()
{
  var deployedRoleSet: Array<StudioEntRole>? = null
  var deployedUserSettingSet: Array<DtoStudioVarUserSettingWrapper>? = null
  lateinit var entUserSet: Array<DtoEntUser>
}