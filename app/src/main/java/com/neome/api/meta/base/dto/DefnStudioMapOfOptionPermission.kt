// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnStudioDtoOptionPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole

class DefnStudioMapOfOptionPermission {
    val keys: MetaIdRole[]
    val map: Record<MetaIdRole, DefnStudioDtoOptionPermission>
}
