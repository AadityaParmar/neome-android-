// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.Types.MetaIdVar;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class StudioEntAutomationStepSendEmail extends StudioEntAutomationStepSendMessageBase
{
  @Nullable
  public MetaIdField[] bccFieldIdSet;

  @Nullable
  public MetaIdVar bccSetOfUserVarId;

  @Nullable
  public MetaIdField[] ccFieldIdSet;

  @Nullable
  public MetaIdVar ccSetOfUserVarId;

  @Nullable
  public MetaIdField mediaFieldId;

  @Nullable
  public StudioValueVarIdParagraph messageVarId;

  @Nullable
  public MetaIdField replyToFieldId;

  @Nullable
  public MetaIdVar replyToSetOfUserVarId;

  @Nullable
  public StudioValueVarIdText subjectVarId;

  @Nullable
  public MetaIdField[] toFieldIdSet;
}
