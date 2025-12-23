// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.nucleus.base.msg.Msg

open class MsgSpreadsheetHistoryFormValue : Msg()
{
  lateinit var formId: MetaIdForm
  lateinit var formValueRefKey: String
  lateinit var version: String
}