// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.SnapshotId
import com.neome.api.meta.base.dto.StudioBase

class SnapshotAvatar : StudioBase() {
    val createdBy: AdminId
    val createdByName: string
    val dateTime: string
    val entVersion: string
    val name: string
    var parentSnapshotId: SnapshotId? = null
    val snapshotId: SnapshotId
}
