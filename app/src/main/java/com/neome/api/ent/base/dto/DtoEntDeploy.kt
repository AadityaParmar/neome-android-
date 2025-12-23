// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoVarUserSetting
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.ent.entDrawer.sig.SigEntAvatarUser
import com.neome.api.meta.base.dto.StudioEntRole

open class DtoEntDeploy
{
  lateinit var avatar: SigEntAvatarUser
  lateinit var roleMap: Map<MetaIdRole, StudioEntRole>
  lateinit var userSettingVarMap: Map<MetaIdVar, DtoVarUserSetting>
}