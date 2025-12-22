// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnPromptAttachmentFormat;
import com.neome.java.api.meta.base.Types.MetaIdPrompt;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntPromptMap extends StudioBase
{
  @Nullable
  public MetaIdVar adhocPromptMappingVarId;

  @Nullable
  public MetaIdSpreadsheet adhocPromptSpreadsheetId;

  @Nullable
  public String[] fieldSeparatorSet;

  public MetaIdPrompt[] keys;

  @Nullable
  public String lineSeparator;

  public Map<MetaIdPrompt, StudioEntPrompt> map;

  @Nullable
  public EnumDefnPromptAttachmentFormat promptAttachmentFormat;

  @Nullable
  public Boolean reviewBeforeExecuting;

  @Nullable
  public Boolean sendReviewDeeplinkOnError;

  @Nullable
  public Boolean sendSuccessDeeplink;
}
