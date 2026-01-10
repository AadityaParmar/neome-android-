// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

interface EntVdRowForward : EntVdAutoStep {
    val fromSender: StudioBuildArgBinder?
    val rowIdPointer: StudioDtoRowIdPointer?
    val toGroupIdSet: List<MetaIdGroup>?
    val toUsers: StudioDtoUserFilter?
}
