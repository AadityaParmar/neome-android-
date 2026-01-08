// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink

interface DeeplinkDataPayloadEntHeader
{
  val hyperLinkSet: Array<DefnDtoHyperLink>?
  val showEnterprise: Boolean?
  val showHeader: Boolean?
  val showSeparator: Boolean?
}