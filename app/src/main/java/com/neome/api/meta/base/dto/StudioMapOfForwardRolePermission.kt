// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfMetaId

interface StudioMapOfForwardRolePermission : StudioBase
{
  val keys: Array<MetaIdRole>
  val map: Map<MetaIdRole, StudioSetOfMetaId>
}