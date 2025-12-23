// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction

open class DefnStudioMapOfActionPermission
{
  lateinit var keys: Array<MetaIdAction>
  lateinit var map: Map<MetaIdAction, DefnStudioDtoActionPermission>
}