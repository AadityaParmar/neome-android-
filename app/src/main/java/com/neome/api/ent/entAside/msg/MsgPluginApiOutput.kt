// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg

open class MsgPluginApiOutput : Msg()
{
  lateinit var fieldId: MetaIdField
  lateinit var formId: MetaIdForm
  var formValueRaw: FormValueRaw? = null
}