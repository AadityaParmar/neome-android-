// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import com.neome.api.core.session.sig.SigTopic
import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.meta.base.Types.MessageId

class SigTopicMessageProps : SigTopic() {
    val messageId: MessageId
    val receiptStatus: EnumReceiptStatus
}
