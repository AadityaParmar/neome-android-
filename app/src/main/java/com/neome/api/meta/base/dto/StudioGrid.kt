// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioComposite
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid

interface StudioGrid : StudioComposite
{
  val layoutGridMap: StudioMapOfLayoutGrid?
  val maxRows: Long?
  val maxRowsVarId: MetaIdVar?
  val metaId: MetaIdGrid
  val minRows: Long?
  val minRowsVarId: MetaIdVar?
  val rowActionPermissionMap: StudioMapOfActionPermission?
  val showAllRowsFieldId: MetaIdField?
}