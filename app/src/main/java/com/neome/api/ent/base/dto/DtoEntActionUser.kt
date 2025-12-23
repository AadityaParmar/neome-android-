// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.Types.MetaIdLayoutUser

open class DtoEntActionUser : DtoEntAction()
{
  var layoutUserId: MetaIdLayoutUser? = null
}