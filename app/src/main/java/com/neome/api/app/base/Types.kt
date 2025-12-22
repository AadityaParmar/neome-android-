// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.base

class Types {
    enum class EnumKindAiAssist {
        module,
        plugin,
        role,

        var ,
        form,
        composite,
        field,
        formula,
        visibilityRule,
        formLayout,
        spreadsheet,
        layoutSpreadsheet,
        report,
        automation,
        eventAndStep,
        action,
        group,
        deeplink,
        driveSheet,
        prompt
    }

    enum class EnumKindNeoScript {
        action,
        deeplink,
        driveSheet,
        form,
        formula,
        group,
        layout,
        layoutSpreadsheet,
        menu,
        module,
        permission,
        plugin,
        report,
        role,
        spreadsheet,
        translation,

        var ,
        visibilityRule
    }
}
