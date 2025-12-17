// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGroup;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdSendMessageToGroups extends EntVdAutoStep
{
  @Nullable
  public StudioValueParagraph message;

  @Nullable
  public StudioBuildArgBinder sender;

  @Nullable
  public MetaIdGroup[] toGroupIdSet;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
