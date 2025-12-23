// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink

open class DeeplinkDataPayloadEntHeader
{
  var hyperLinkSet: Array<DefnDtoHyperLink>? = null
  var showEnterprise: Boolean? = null
  var showHeader: Boolean? = null
  var showSeparator: Boolean? = null
}