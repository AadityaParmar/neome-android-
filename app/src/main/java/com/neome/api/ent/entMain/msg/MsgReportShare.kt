// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.nucleus.base.msg.Msg

interface MsgReportShare : Msg
{
  val actionId: MetaIdAction
  val inputFormValueRaw: FormValueRaw?
  val reportId: MetaIdReport
  val reset: Boolean?
}