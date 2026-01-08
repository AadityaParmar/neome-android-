// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base.dto

import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoNeoScriptPermission : DtoNeoScript
{
  val compositeId: MetaIdComposite?
  val fieldId: MetaIdField?
  val formId: MetaIdForm?
  val spreadsheetId: MetaIdSpreadsheet?
}