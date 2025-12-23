// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupFreezeSetting
import com.neome.api.meta.base.Types.GroupId
import java.util.Map

open class DtoEntGroupFreezeSettingMap
{
  lateinit var groupMap: Map<GroupId, DtoEntGroupFreezeSetting>
}