// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.home.main.sig.SigSpreadsheetRow

interface DeeplinkDataPayloadEntSpreadsheetRowShare : DeeplinkDataPayloadEnt
{
  val defnForm: DefnForm?
  val formContentLayoutId: MetaIdLayoutForm?
  val formTemplateLayoutId: MetaIdLayoutForm?
  val isPublicUpdateAllowed: Boolean?
  val spreadsheetRow: SigSpreadsheetRow?
}