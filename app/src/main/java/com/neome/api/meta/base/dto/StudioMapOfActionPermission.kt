// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoActionPermission

interface StudioMapOfActionPermission : StudioBase
{
  val keys: Array<MetaIdAction>
  val map: Map<MetaIdAction, StudioDtoActionPermission>
}