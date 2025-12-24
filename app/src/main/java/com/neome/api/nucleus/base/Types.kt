// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base

import com.neome.api.meta.base.AnyKey
import com.neome.api.meta.base.AnyValue

object Types
{
  class AnyOtpValue : AnyValue()
  class AnyPrefixKey : AnyKey()
  class AppVersion : AnyValue()

  enum class EnumAnalyticEventFilterKind(val value: String)
  {
    todayActiveUsers("todayActiveUsers"),
    dailyActiveUsers("dailyActiveUsers"),
    monthlyActiveUsers("monthlyActiveUsers"),
    totalMessages("totalMessages"),
    totalReportAccess("totalReportAccess"),
    totalSpreadsheetEdits("totalSpreadsheetEdits"),
    totalNetworkIn("totalNetworkIn"),
    totalNetworkOut("totalNetworkOut"),
    totalMediaIn("totalMediaIn"),
    totalMediaOut("totalMediaOut")
  }

  enum class EnumAnalyticEventType(val value: String)
  {
    activeUser("activeUser"),
    mediaIn("mediaIn"),
    mediaOut("mediaOut"),
    message("message"),
    networkIn("networkIn"),
    networkOut("networkOut"),
    report("report"),
    spreadsheetEdit("spreadsheetEdit")
  }

  enum class EnumApiMethod(val value: String)
  {
    delete("delete"),
    get("get"),
    patch("patch"),
    post("post"),
    put("put")
  }

  enum class EnumApiToken(val value: String)
  {
    bearer("bearer"),
    refresh("refresh"),
    refreshOptional("refreshOptional"),
    none("none")
  }

  enum class EnumApiVer(val value: String)
  {
    v1("v1")
  }

  enum class EnumArtifactMemberType(val value: String)
  {
    admin("admin"),
    user("user")
  }

  enum class EnumConnType(val value: String)
  {
    rpc("rpc"),
    wsoc("wsoc"),
    media("media")
  }

  enum class EnumDeployKind(val value: String)
  {
    prod("prod"),
    beta("beta"),
    localHost("localHost"),
    test("test")
  }

  enum class EnumEnvErrorCode(val value: String)
  {
    badRequest("badRequest"),
    cancelledRequest("cancelledRequest"),
    pluginError("pluginError"),
    serverError("serverError"),
    automationError("automationError"),
    serviceUnavailable("serviceUnavailable"),
    unauthorizedRefreshToken("unauthorizedRefreshToken"),
    unauthorizedBearerToken("unauthorizedBearerToken"),
    upgradeForce("upgradeForce"),
    upgradeSuggest("upgradeSuggest"),
    validationError("validationError"),
    networkError("networkError")
  }

  enum class EnumMediaExchangeStatus(val value: String)
  {
    cancel("cancel"),
    notFound("notFound"),
    dropped("dropped"),
    success("success"),
    timeout("timeout"),
    priorFileFound("priorFileFound"),
    priorTempFileFound("priorTempFileFound"),
    priorServerError("priorServerError"),
    connectionFailed("connectionFailed")
  }

  enum class EnumScopeType(val value: String)
  {
    ent("ent"),
    global("global"),
    globalOrEnt("globalOrEnt"),
    plugin("plugin"),
    pluginOrEnt("pluginOrEnt"),
    store("store"),
    any("any")
  }
}