// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutUser
import com.neome.api.meta.base.dto.StudioEntAction

interface StudioEntActionUser : StudioEntAction
{
  val layoutUserId: MetaIdLayoutUser?
}