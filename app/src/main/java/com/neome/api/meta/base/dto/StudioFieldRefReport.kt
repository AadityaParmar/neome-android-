// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioDtoLayoutOverlaySpreadsheet
import com.neome.api.meta.base.dto.StudioField

interface StudioFieldRefReport : StudioField
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: List<MetaIdField>?
  val forceOpenOnFormCreate: Boolean?
  val forceOpenOnGridRowCreate: Boolean?
  val gridId: MetaIdGrid?
  val keyFieldIdSet: List<MetaIdField>?
  val layoutGridId: MetaIdLayoutGrid?
  val mobileLayoutGridId: MetaIdLayoutGrid?
  val mobileOverlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheet?
  val overlayLayoutGrid: StudioDtoLayoutOverlaySpreadsheet?
  val reportId: MetaIdReport?
}