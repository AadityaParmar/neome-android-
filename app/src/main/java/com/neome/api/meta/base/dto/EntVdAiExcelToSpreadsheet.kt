// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAi
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdAiExcelToSpreadsheet : EntVdAi
{
  val inputField: StudioDtoArgValueParameter?
  val spreadsheetId: MetaIdSpreadsheet?
}