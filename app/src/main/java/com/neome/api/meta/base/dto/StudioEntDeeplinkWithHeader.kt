// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntDeeplink

interface StudioEntDeeplinkWithHeader : StudioEntDeeplink
{
  val hyperlinkVarIdSet: List<MetaIdVar>?
  val showEnterprise: Boolean?
  val showHeader: Boolean?
  val transparentHeader: Boolean?
}