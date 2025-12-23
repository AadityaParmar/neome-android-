// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DeeplinkDataPayloadEnt
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DeeplinkDataPayloadEntSpreadsheetEditorShare : DeeplinkDataPayloadEnt()
{
  lateinit var entId: EntId
  lateinit var layoutSpreadsheetId: MetaIdLayoutGrid
  lateinit var metaIdAction: MetaIdAction
  lateinit var metaIdSpreadsheet: MetaIdSpreadsheet
}