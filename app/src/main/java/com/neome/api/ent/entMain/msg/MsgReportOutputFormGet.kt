// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

interface MsgReportOutputFormGet : Msg
{
  val actionId: MetaIdAction
  val inputFormCompositeId: MetaIdComposite?
  val inputFormGridRowId: RowId?
  val inputFormValue: FormValueRaw?
}