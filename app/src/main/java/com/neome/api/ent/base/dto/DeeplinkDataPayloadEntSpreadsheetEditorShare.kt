// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DeeplinkDataPayloadEntSpreadsheetEditorShare : DeeplinkDataPayloadEnt() {
    val entId: EntId
    val layoutSpreadsheetId: MetaIdLayoutGrid
    val metaIdAction: MetaIdAction
    val metaIdSpreadsheet: MetaIdSpreadsheet
}
