// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

class MsgMessageForwardCandidateList : Msg() {
    var spreadsheetId: MetaIdSpreadsheet? = null
}
