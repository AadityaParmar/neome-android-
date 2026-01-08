// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOptionPermission

interface StudioMapOfOptionPermission : StudioBase
{
  val keys: Array<MetaIdRole>
  val map: Map<MetaIdRole, StudioDtoOptionPermission>
}