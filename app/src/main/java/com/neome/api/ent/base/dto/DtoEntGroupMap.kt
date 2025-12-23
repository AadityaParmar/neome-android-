// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroup
import com.neome.api.meta.base.Types.GroupId
import java.util.Map

open class DtoEntGroupMap
{
  lateinit var entGroupMap: Map<GroupId, DtoEntGroup>
}