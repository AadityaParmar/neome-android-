// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction

interface DefnStudioMapOfActionPermission
{
  val keys: Array<MetaIdAction>
  val map: Map<MetaIdAction, DefnStudioDtoActionPermission>
}