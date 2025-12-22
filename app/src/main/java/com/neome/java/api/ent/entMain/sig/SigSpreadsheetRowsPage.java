// neome.ai API - do not change
//

package com.neome.java.api.ent.entMain.sig;

import com.neome.java.api.ent.base.dto.DtoFieldFilter;
import com.neome.java.api.home.main.sig.SigSpreadsheetRow;
import com.neome.java.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.java.api.meta.base.dto.DefnForm;
import com.neome.java.api.meta.base.dto.DefnLayoutGridMap;
import com.neome.java.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class SigSpreadsheetRowsPage extends Sig
{
  public DtoFieldFilter[] filterList;

  public boolean hasMoreRows;

  public DefnForm outputForm;

  public SigSpreadsheetRow[] rowList;

  @Nullable
  public DefnLayoutGridMap spreadSheetLayoutMap;

  @Nullable
  public MetaIdSpreadsheet spreadsheetId;
}
