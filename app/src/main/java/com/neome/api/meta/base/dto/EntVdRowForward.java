// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.MetaIdGroup;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdRowForward extends EntVdAutoStep
{
  @Nullable
  public StudioBuildArgBinder fromSender;

  @Nullable
  public StudioDtoRowIdPointer rowIdPointer;

  @Nullable
  public MetaIdGroup[] toGroupIdSet;

  @Nullable
  public StudioDtoUserFilter toUsers;
}
