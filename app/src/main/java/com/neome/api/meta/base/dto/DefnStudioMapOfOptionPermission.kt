// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoOptionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole

open class DefnStudioMapOfOptionPermission
{
  lateinit var keys: Array<MetaIdRole>
  lateinit var map: Map<MetaIdRole, DefnStudioDtoOptionPermission>
}