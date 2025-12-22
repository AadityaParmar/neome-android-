// neome.ai API - do not change
//

package com.neome.java.api.ent.entAside.sig;

import com.neome.java.api.home.main.sig.SigSpreadsheetRow;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.dto.DefnForm;
import com.neome.java.api.meta.base.dto.DefnLayoutGridMap;
import com.neome.java.api.nucleus.base.sig.SigVersion;

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
