// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DtoGridLayoutRefKey
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.dto.GsonCto
import com.neome.api.meta.base.Types.MetaIdForm

interface DtoEntFormExportExcel : GsonCto
{
  val formId: MetaIdForm
  val formValueRaw: FormValueRaw
  val layoutRefKeyList: List<DtoGridLayoutRefKey>
}