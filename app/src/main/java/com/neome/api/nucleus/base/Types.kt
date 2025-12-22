// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.AnyKey
import com.neome.api.meta.base.AnyValue

class Types {
    class AnyOtpValue : AnyValue()
    class AnyPrefixKey : AnyKey()
    class AppVersion : AnyValue()

    enum class EnumAnalyticEventFilterKind {
        todayActiveUsers,
        dailyActiveUsers,
        monthlyActiveUsers,
        totalMessages,
        totalReportAccess,
        totalSpreadsheetEdits,
        totalNetworkIn,
        totalNetworkOut,
        totalMediaIn,
        totalMediaOut
    }

    enum class EnumAnalyticEventType {
        activeUser,
        mediaIn,
        mediaOut,
        message,
        networkIn,
        networkOut,
        report,
        spreadsheetEdit
    }

    enum class EnumApiMethod {
        delete,
        get,
        patch,
        post,
        put
    }

    enum class EnumApiToken {
        bearer,
        refresh,
        refreshOptional,
        none
    }

    enum class EnumApiVer {
        v1
    }

    enum class EnumArtifactMemberType {
        admin,
        user
    }

    enum class EnumConnType {
        rpc,
        wsoc,
        media
    }

    enum class EnumDeployKind {
        prod,
        beta,
        localHost,
        test
    }

    enum class EnumEnvErrorCode {
        badRequest,
        cancelledRequest,
        pluginError,
        serverError,
        automationError,
        serviceUnavailable,
        unauthorizedRefreshToken,
        unauthorizedBearerToken,
        upgradeForce,
        upgradeSuggest,
        validationError,
        networkError
    }

    enum class EnumMediaExchangeStatus {
        cancel,
        notFound,
        dropped,
        success,
        timeout,
        priorFileFound,
        priorTempFileFound,
        priorServerError,
        connectionFailed
    }

    enum class EnumScopeType {
        ent,
        global,
        globalOrEnt,
        plugin,
        pluginOrEnt,
        store,
        any
    }
}
