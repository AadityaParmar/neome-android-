// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoHyperLink
import com.neome.api.meta.base.dto.FieldDtoImage
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdHyperlink
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnLayoutFormHeader
{
  val backgroundColor: DefnDtoColor?
  val backgroundColorVar: DefnDtoColor?
  val formLayoutId: MetaIdLayoutForm?
  val headerImage: FieldDtoImage?
  val headerImageHeight: Long?
  val headerImageVar: FieldDtoImage?
  val hyperLinkMap: Map<MetaIdHyperlink, DefnDtoHyperLink>?
  val hyperlinkKeys: Array<MetaIdHyperlink>?
  val showEnterprise: Boolean?
  val showSeparator: Boolean?
  val textColor: DefnDtoColor?
  val textColorVar: DefnDtoColor?
}