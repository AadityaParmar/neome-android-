package com.neome.core.common.serializer.api

import com.neome.api.home.base.Types

interface SigMessage : SigMessageBase {
    var receiptStatus: Types.EnumReceiptStatus?
    var version: String?
}
