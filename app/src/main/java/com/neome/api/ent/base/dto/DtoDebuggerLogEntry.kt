// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumLogType
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DtoLogTree
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.dto.EnvError

class DtoDebuggerLogEntry {
    var caller: string? = null
    var dateTime: string? = null
    var envError: EnvError? = null
    var inputForm: DefnForm? = null
    var inputFormLogTree: DtoLogTree? = null
    var inputFormValue: FormValueRaw? = null
    var logType: EnumLogType? = null
    var name: string? = null
    var outputForm: DefnForm? = null
    var outputFormLogTree: DtoLogTree? = null
    var outputFormValue: FormValueRaw? = null
    var summary:

    object? = null
}
