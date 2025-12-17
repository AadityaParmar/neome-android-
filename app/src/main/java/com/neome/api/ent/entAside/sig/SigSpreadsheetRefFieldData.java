// neome.ai API - do not change
//

package com.neome.api.ent.entAside.sig;

import com.neome.api.home.main.sig.SigSpreadsheetRow;
import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.DefnForm;
import com.neome.api.meta.base.dto.DefnLayoutGridMap;
import com.neome.api.nucleus.base.sig.SigVersion;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRefFieldData extends SigVersion
{
  public DefnForm outputForm;

  public SigSpreadsheetRow[] rowList;

  @Nullable
  public DefnLayoutGridMap spreadSheetLayoutMap;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
