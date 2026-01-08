// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSetting
import com.neome.api.meta.base.Types.GroupId

interface DtoEntGroupFreezeSettingMap
{
  val groupMap: Map<GroupId, DtoEntGroupFreezeSetting>
}