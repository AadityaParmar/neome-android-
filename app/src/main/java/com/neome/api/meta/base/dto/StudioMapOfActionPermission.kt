// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoActionPermission

open class StudioMapOfActionPermission : StudioBase()
{
  lateinit var keys: Array<MetaIdAction>
  lateinit var map: Map<MetaIdAction, StudioDtoActionPermission>
}