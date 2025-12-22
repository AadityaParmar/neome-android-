// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

class EntVdSendMessageToGroups : EntVdAutoStep() {
    var message: StudioValueParagraph? = null
    var sender: StudioBuildArgBinder? = null
    var toGroupIdSet: MetaIdGroup[]? = null
    var toUsers: StudioDtoUserFilter? = null
}
