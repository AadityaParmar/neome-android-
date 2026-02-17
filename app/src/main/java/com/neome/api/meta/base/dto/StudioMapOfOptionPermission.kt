// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOptionPermission

interface StudioMapOfOptionPermission : StudioBase
{
  val keys: List<MetaIdRole>
  val map: Map<MetaIdRole, StudioDtoOptionPermission>
}