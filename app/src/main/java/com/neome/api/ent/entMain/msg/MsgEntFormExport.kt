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

interface MsgEntFormExport : Msg
{
  val contentLayoutId: MetaIdLayoutForm
  val entId: EntId
  val exportType: EnumFormExportType
  val formId: MetaIdForm
  val formValueRaw: FormValueRaw
  val height: Long?
  val templateLayoutId: MetaIdLayoutForm?
  val width: Long?
}