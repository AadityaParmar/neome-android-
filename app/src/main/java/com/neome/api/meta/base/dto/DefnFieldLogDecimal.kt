// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldDecimal
import com.neome.api.meta.base.Types.MetaIdRole

interface DefnFieldLogDecimal : DefnFieldDecimal
{
  val hideInfo: Boolean?
  val logReadRoleSet: Array<MetaIdRole>?
}