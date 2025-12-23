// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgButtonWorkflowExecute : Msg()
{
  lateinit var buttonFieldId: MetaIdField
  lateinit var buttonFormId: MetaIdForm
  lateinit var formValue: FormValueRaw
  var fromGridId: MetaIdGrid? = null
  var fromGridRowId: RowId? = null
}