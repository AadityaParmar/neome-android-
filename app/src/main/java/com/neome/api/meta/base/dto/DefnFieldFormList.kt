// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItem
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

open class DefnFieldFormList : DefnField()
{
  var bgColorFieldId: MetaIdField? = null
  var cardLayoutItemHideBorders: Boolean? = null
  var cardLayoutNumOfColumns: Number? = null
  var displayItemId: MetaIdField? = null
  var displaySectionId: MetaIdSection? = null
  var editableFieldIdSet: Array<MetaIdField>? = null
  var hideMenu: Boolean? = null
  var ignoreSelection: Boolean? = null
  var isPickMany: Boolean? = null
  var itemHeight: Number? = null
  var layout: DefnDtoLayoutCardItem? = null
  var pickRowOnFieldIdSet: Array<MetaIdField>? = null
  var showAsCardLayout: Boolean? = null
}