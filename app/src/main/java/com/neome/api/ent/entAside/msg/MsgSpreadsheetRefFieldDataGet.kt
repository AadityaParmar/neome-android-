// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.core.base.msg.MsgVersion

interface MsgSpreadsheetRefFieldDataGet : MsgVersion
{
  val ascOrder: Boolean?
  val formId: MetaIdForm
  val formSpreadsheetId: MetaIdSpreadsheet?
  val inputFormValueRaw: FormValueRaw
  val refFieldId: MetaIdComp
  val sortByFieldIdSet: List<MetaIdField>?
}