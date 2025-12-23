// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.session.sig

import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.core.session.sig.SigTopic

open class SigTopicMessageProps : SigTopic()
{
  lateinit var messageId: MessageId
  lateinit var receiptStatus: EnumReceiptStatus
}