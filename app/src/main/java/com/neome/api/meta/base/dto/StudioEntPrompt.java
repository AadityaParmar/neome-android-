// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Symbol;
import com.neome.api.meta.base.Types.EnumDefnPromptAttachmentFormat;
import com.neome.api.meta.base.Types.MetaIdAction;
import com.neome.api.meta.base.Types.MetaIdPrompt;
import com.neome.api.meta.base.Types.MetaIdRole;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntPrompt extends StudioBase
{
  @Nullable
  public MetaIdAction actionId;

  public MetaIdPrompt metaId;

  @Nullable
  public StudioModuleSelection modules;

  public Symbol name;

  @Nullable
  public MetaIdRole[] permissionRoleIdSet;

  @Nullable
  public EnumDefnPromptAttachmentFormat promptAttachmentFormat;

  @Nullable
  public StudioValueCodeJavascript promptText;

  @Nullable
  public Boolean reviewBeforeExecuting;

  @Nullable
  public Boolean sendReviewDeeplinkOnError;

  @Nullable
  public Boolean sendSuccessDeeplink;
}
