// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.GroupId;
import com.neome.api.meta.base.Types.Key;
import com.neome.api.meta.base.Types.MetaIdAutomation;
import com.neome.api.meta.base.Types.MetaIdGroup;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.Types.SchedulerTaskId;
import com.neome.api.meta.base.Types.SheetId;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

@SuppressWarnings("unused")
public class StudioEntPrivateState extends StudioBase
{
  @Nullable
  public Long cliSeedId;

  @Nullable
  public Map<Key, SchedulerTaskId> eventSchedulerTaskIdMapping;

  @Nullable
  public Map<MetaIdGroup, GroupId> groupIdMappingMap;

  @Nullable
  public String[] refTokenSet;

  @Nullable
  public Map<MetaIdAutomation, SchedulerTaskId> schedulerTaskIdMappingMap;

  @Nullable
  public Map<MetaIdSpreadsheet, SheetId> sheetIdMappingMap;

  @Nullable
  public Map<MetaIdSpreadsheet, StudioEntSpreadsheetRefTokenMap> spreadsheetRefTokenMap;
}
