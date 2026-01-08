// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgFormMappingResultGet : Msg
{
  val inputFormGridRowId: RowId?
  val inputFormId: MetaIdForm
  val inputFormValueRaw: FormValueRaw
  val mappingVarId: MetaIdVar
  val outputFormGridRowId: RowId?
  val outputFormId: MetaIdForm
  val outputFormValueRaw: FormValueRaw?
}