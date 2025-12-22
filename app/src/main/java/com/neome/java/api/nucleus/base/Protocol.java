// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base;

import com.neome.java.api.core.base.msg.MsgVersion;
import com.neome.java.api.home.base.Types.EnumMessageType;
import com.neome.java.api.meta.base.Types.EnumEnvValidationError;
import com.neome.java.api.meta.base.dto.EnvValidationError;
import com.neome.java.api.meta.base.sig.ISig;
import com.neome.java.api.nucleus.base.dto.EnvError;
import com.neome.java.api.nucleus.base.dto.EnvSignal;

import java.util.LinkedHashSet;
import java.util.Set;

public class Protocol
{
  private static final String ERR_COMPUTER_NOT_CONNECTED = "Computer not connected";

  public static MsgVersion createMsgVersion(String version)
  {
    MsgVersion msgVersion = new MsgVersion();
    msgVersion.version = version != null
      ? version
      : "";
    return msgVersion;
  }

  public static String getErrorMessage(EnvError envError)
  {
    if(envError == null)
    {
      return null;
    }

    Types.EnumEnvErrorCode errorCode = envError.errorCode;
    if(errorCode == Types.EnumEnvErrorCode.networkError)
    {
      if(envError.errorMessage != null)
      {
        return ERR_COMPUTER_NOT_CONNECTED;
      }
      else
      {
        return null;
      }
    }
    String errorMessage = envError.errorMessage;
    if(errorMessage != null)
    {
      return envError.errorParams == null
        ? errorMessage
        : String.format(errorMessage, (Object[]) envError.errorParams);
    }

    if(errorCode == Types.EnumEnvErrorCode.validationError)
    {
      EnvValidationError[] validationErrors = envError.validationErrors;
      if(validationErrors != null && validationErrors.length > 0)
      {
        return getValidationErrorMessage(validationErrors[0]);
      }
    }
    // this should not happen, just a fallback
    return String.valueOf(envError.errorCode);
  }

  public static <S extends ISig> String getErrorText(EnvSignal<S> envSig)
  {
    EnvError envError = envSig.error;
    if(envError == null)
    {
      return null;
    }

    Types.EnumEnvErrorCode errorCode = envError.errorCode;
    if(errorCode == Types.EnumEnvErrorCode.networkError)
    {
      if(envError.errorMessage != null)
      {
        return envError.errorMessage;
      }
      else
      {
        return ERR_COMPUTER_NOT_CONNECTED;
      }
    }
    return getErrorMessage(envError);
  }

  public static String[] getParamNameSet(EnvValidationError validationError)
  {
    if(validationError.paramName == null)
    {
      return validationError.paramNameSet == null
        ? new String[]{}
        : validationError.paramNameSet;
    }
    else
    {
      return new String[]{validationError.paramName};
    }
  }

  public static <T extends ISig> T getSig(EnvSignal<T> envSig)
  {
    return envSig.sig;
  }

  @SuppressWarnings("DataFlowIssue")
  public static String getValidationErrorMessage(EnvValidationError validationError)
  {
    return validationError.errorParams == null
      ? validationError.errorMessage
      : String.format(validationError.errorMessage, (Object[]) validationError.errorParams);
  }

  public static Set<String> getValidationErrorsCode(EnvError param)
  {
    if(param == null)
    {
      return Set.of();
    }

    if(param.errorCode == Types.EnumEnvErrorCode.validationError)
    {
      EnvValidationError[] validationErrors = param.validationErrors;
      if(validationErrors != null && validationErrors.length > 0)
      {
        Set<String> result = new LinkedHashSet();
        for(int i = 0; i < validationErrors.length; i++)
        {
          //noinspection DataFlowIssue
          result.add(validationErrors[i].errorCode.name());
        }

        return result;
      }
    }

    return Set.of();
  }

  public static boolean isDownloadableMessage(EnumMessageType messageType)
  {
    return messageType == EnumMessageType.audio || messageType == EnumMessageType.camera ||
      messageType == EnumMessageType.document || messageType == EnumMessageType.image ||
      messageType == EnumMessageType.video || messageType == EnumMessageType.voice;
  }

  public static <S extends ISig> boolean isNotChangedSignal(EnvSignal<S> param)
  {
    return isNotChangedSignal(param.error);
  }

  public static <S extends ISig> boolean isNetworkError(EnvSignal<S> param)
  {
    return param.error != null && Types.EnumEnvErrorCode.networkError.equals(param.error.errorCode);
  }

  public static <S extends ISig> boolean isRuleViolationSignal(EnvSignal<S> param)
  {
    return isRuleViolation(param.error);
  }

  public static Boolean isNotChangedSignal(EnvError param)
  {
    return getValidationErrorsCode(param).contains(EnumEnvValidationError.notChanged.name());
  }

  public static Boolean isRuleViolation(EnvError param)
  {
    return getValidationErrorsCode(param).contains(EnumEnvValidationError.ruleViolation.name());
  }

  public static <S extends ISig> Boolean isNotFoundSignal(EnvSignal<S> param)
  {
    return isNotFoundSignal(param.error);
  }

  public static Boolean isNotFoundSignal(EnvError param)
  {
    return getValidationErrorsCode(param).contains(EnumEnvValidationError.notFound.name());
  }

  public enum EnumMessageTypeStar
  {
    audio,
    camera,
    document,
    group,
    image,
    linkText,
    location,
    report,
    spreadsheetPartition,
    spreadsheetRow,
    text,
    user,
    video,
    voice
  }

  public enum OnlyPushTopicType
  {
    callerStarMessageList,
    messageRemoveForMe
  }
}
