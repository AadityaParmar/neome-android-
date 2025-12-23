// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.home.main.sig.SigSpreadsheetRow

open class DeeplinkDataPayloadEntSpreadsheetRowShare : DeeplinkDataPayloadEnt()
{
  var defnForm: DefnForm? = null
  var formContentLayoutId: MetaIdLayoutForm? = null
  var formTemplateLayoutId: MetaIdLayoutForm? = null
  var isPublicUpdateAllowed: Boolean? = null
  var spreadsheetRow: SigSpreadsheetRow? = null
}