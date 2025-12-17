// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdBotHistoryRemove extends EntVdAutoStep
{
  @Nullable
  public StudioDtoArgValueParameter historyIdField;

  @Nullable
  public Boolean removeAll;

  @Nullable
  public Long retainCount;
}
