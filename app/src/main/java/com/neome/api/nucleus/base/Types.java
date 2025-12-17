// neome.ai API - do not change
//

package com.neome.api.nucleus.base;

import com.neome.api.meta.base.AnyKey;
import com.neome.api.meta.base.AnyValue;

@SuppressWarnings({
  "unused",
  "ClassTooDeepInInheritanceTree"
})
public class Types
{
  public enum EnumAnalyticEventFilterKind
  {
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
  public enum EnumAnalyticEventType
  {
    activeUser,
    mediaIn,
    mediaOut,
    message,
    networkIn,
    networkOut,
    report,
    spreadsheetEdit
  }
  public enum EnumApiMethod
  {
    delete,
    get,
    patch,
    post,
    put
  }

  public enum EnumApiToken
  {
    bearer,
    refresh,
    refreshOptional,
    none
  }

  public enum EnumApiVer
  {
    v1
  }

  public enum EnumArtifactMemberType
  {
    admin,
    user
  }

  public enum EnumConnType
  {
    rpc,
    wsoc,
    media
  }

  public enum EnumDeployKind
  {
    prod,
    beta,
    localHost,
    test
  }

  public enum EnumEnvErrorCode
  {
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

  public enum EnumMediaExchangeStatus
  {
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

  public enum EnumScopeType
  {
    ent,
    global,
    globalOrEnt,
    plugin,
    pluginOrEnt,
    store,
    any
  }
  public static class AnyOtpValue extends AnyValue
  {
  }
  public static class AnyPrefixKey extends AnyKey
  {
  }
  public static class AppVersion extends AnyValue
  {
  }
}
