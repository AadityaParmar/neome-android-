// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdGenerateExcel : EntVdAutoStep
{
  val fileName: StudioValueText?
  val formId: MetaIdPipelineParam?
  val gridLayoutMap: Map<MetaIdGrid, MetaIdLayoutGrid>?
  val outputField: StudioDtoArgValueParameter?
  val rowIdField: StudioDtoArgValueParameter?
  val spreadsheetId: MetaIdSpreadsheet?
  val spreadsheetLayoutId: MetaIdLayoutGrid?
}