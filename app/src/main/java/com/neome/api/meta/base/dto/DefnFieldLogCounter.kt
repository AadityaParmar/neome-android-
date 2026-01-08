// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldCounter
import com.neome.api.meta.base.Types.MetaIdRole

interface DefnFieldLogCounter : DefnFieldCounter
{
  val hideInfo: Boolean?
  val logReadRoleSet: Array<MetaIdRole>?
}