// neome.ai API - do not change
//

package com.neome.api.ent.base.dto;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.DefnLayoutGridMap;

import java.util.Map;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef;
import com.neome.api.meta.base.Symbol;

@SuppressWarnings("unused")
public class DtoEntSpreadsheet
{
  public boolean canClear;

  public boolean canExpire;

  public MetaIdRole[] forwardRoleIdSet;

  public boolean hasPartition;

  public MetaIdRole[] insertRoleIdSet;

  @Nullable
  public String label;

  @Nullable
  public DefnLayoutGridMap layoutMap;

  public Symbol name;

  public MetaIdRole[] removeRoleIdSet;

  public String sheetIdHash;

  public MetaIdForm spreadsheetFormId;

  @Nullable
  public Map<MetaIdSpreadsheetRef, String> spreadsheetRefTokenMap;

  public boolean supportOffline;

  public MetaIdRole[] updateRoleIdSet;
}
