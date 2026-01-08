// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdMapping
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase
import com.neome.api.meta.base.Symbol

interface StudioDtoMappingGrid : StudioBase
{
  val emptyFieldVariant: EnumDefnEmptyFieldVariant?
  val fieldMappingMap: StudioDtoMappingFieldMapBase?
  val fromGridId: MetaIdGrid?
  val fromGridKey: MetaIdField?
  val insertVariant: EnumDefnInsertVariant?
  val metaId: MetaIdMapping
  val name: Symbol?
  val removeVariant: EnumDefnRemoveVariant?
  val toGridId: MetaIdGrid?
  val toGridKey: MetaIdField?
  val updateVariant: EnumDefnUpdateVariant?
}