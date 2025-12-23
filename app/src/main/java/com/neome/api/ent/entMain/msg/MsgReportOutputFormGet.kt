// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgReportOutputFormGet : Msg()
{
  lateinit var actionId: MetaIdAction
  var inputFormCompositeId: MetaIdComposite? = null
  var inputFormGridRowId: RowId? = null
  var inputFormValue: FormValueRaw? = null
}