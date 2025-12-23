// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioFieldCounter

open class StudioFieldLogCounter : StudioFieldCounter()
{
  var logReadRoleSet: Array<MetaIdRole>? = null
}