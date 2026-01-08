// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdCode
import com.neome.api.meta.base.dto.StudioBase

interface StudioValueCode : StudioBase
{
  val metaId: MetaIdCode
}