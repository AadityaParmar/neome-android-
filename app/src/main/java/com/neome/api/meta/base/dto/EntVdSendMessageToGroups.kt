// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

interface EntVdSendMessageToGroups : EntVdAutoStep {
    val message: StudioValueParagraph?
    val sender: StudioBuildArgBinder?
    val toGroupIdSet: List<MetaIdGroup>?
    val toUsers: StudioDtoUserFilter?
}
