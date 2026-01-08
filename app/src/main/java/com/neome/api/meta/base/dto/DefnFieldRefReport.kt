// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnLayoutGrid
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdReport

interface DefnFieldRefReport : DefnField
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: Array<MetaIdField>?
  val forceOpenOnFormCreate: Boolean?
  val forceOpenOnGridRowCreate: Boolean?
  val gridId: MetaIdGrid?
  val keyFieldIdSet: Array<MetaIdField>?
  val layoutGrid: DefnLayoutGrid?
  val mobileLayoutGrid: DefnLayoutGrid?
  val mobileOverlayLayoutGrid: DefnDtoLayoutOverlaySpreadsheet?
  val overlayLayoutGrid: DefnDtoLayoutOverlaySpreadsheet?
  val reportId: MetaIdReport
}