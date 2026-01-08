// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.FieldDtoImage

interface DefnDtoMedia
{
  val html: DefnDtoParagraph?
  val hyperlink: DefnDtoHyperLink?
  val image: FieldDtoImage?
}