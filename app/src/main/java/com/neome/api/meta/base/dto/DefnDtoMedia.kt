// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.FieldDtoImage

open class DefnDtoMedia
{
  var html: DefnDtoParagraph? = null
  var hyperlink: DefnDtoHyperLink? = null
  var image: FieldDtoImage? = null
}