// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.session.sig

import com.neome.api.core.session.sig.SigTopic
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.Types.RowId

class SigTopicSpreadsheetRef : SigTopic() {
    val metaIdSpreadsheetRef: MetaIdSpreadsheetRef
    val targetRowId: RowId
}
