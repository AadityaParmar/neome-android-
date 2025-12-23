// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EnumFormExportType
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntFormExport : Msg()
{
  lateinit var contentLayoutId: MetaIdLayoutForm
  lateinit var entId: EntId
  lateinit var exportType: EnumFormExportType
  lateinit var formId: MetaIdForm
  lateinit var formValueRaw: FormValueRaw
  var height: Number? = null
  var templateLayoutId: MetaIdLayoutForm? = null
  var width: Number? = null
}