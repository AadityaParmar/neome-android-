// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgReportFieldDataGet : Msg
{
  val formId: MetaIdForm
  val inputFormCompositeId: MetaIdComposite?
  val inputFormGridRowId: RowId?
  val inputFormValue: FormValueRaw
  val reportFieldId: MetaIdField
}