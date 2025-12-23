// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId

open class MsgFormMappingResultGet : Msg()
{
  var inputFormGridRowId: RowId? = null
  lateinit var inputFormId: MetaIdForm
  lateinit var inputFormValueRaw: FormValueRaw
  lateinit var mappingVarId: MetaIdVar
  var outputFormGridRowId: RowId? = null
  lateinit var outputFormId: MetaIdForm
  var outputFormValueRaw: FormValueRaw? = null
}