// neome.ai API - do not change
//

package com.neome.java.api.ent.base.dto;

import com.neome.java.api.meta.base.Symbol;
import com.neome.java.api.meta.base.Types.MetaIdForm;
import com.neome.java.api.meta.base.Types.MetaIdRole;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheetRef;
import com.neome.java.api.meta.base.dto.DefnLayoutGridMap;

import org.jetbrains.annotations.Nullable;

import java.util.Map;

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
