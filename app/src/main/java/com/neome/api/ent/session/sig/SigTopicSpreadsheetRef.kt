// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.session.sig

import com.neome.api.core.session.sig.SigTopic
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.Types.RowId

open class SigTopicSpreadsheetRef : SigTopic() {
    lateinit var metaIdSpreadsheetRef: MetaIdSpreadsheetRef
    lateinit var targetRowId: RowId
}
