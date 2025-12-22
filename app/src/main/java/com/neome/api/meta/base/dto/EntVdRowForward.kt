// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

class EntVdRowForward : EntVdAutoStep() {
    var fromSender: StudioBuildArgBinder? = null
    var rowIdPointer: StudioDtoRowIdPointer? = null
    var toGroupIdSet: MetaIdGroup[]? = null
    var toUsers: StudioDtoUserFilter? = null
}
