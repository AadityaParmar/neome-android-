// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoOptionPermission
import com.neome.api.meta.base.Types.MetaIdRole

interface DefnStudioMapOfOptionPermission
{
  val keys: List<MetaIdRole>
  val map: Map<MetaIdRole, DefnStudioDtoOptionPermission>
}