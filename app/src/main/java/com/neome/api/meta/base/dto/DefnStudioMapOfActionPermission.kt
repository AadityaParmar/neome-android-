// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.api.meta.base.Types.MetaIdAction

interface DefnStudioMapOfActionPermission
{
  val keys: List<MetaIdAction>
  val map: Map<MetaIdAction, DefnStudioDtoActionPermission>
}