// neome.ai API - do not change
//

package com.neome.api.ent.entMain.msg;

import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.nucleus.base.msg.Msg;

@SuppressWarnings("unused")
public class MsgSpreadsheetHistoryFormValue extends Msg
{
  public MetaIdForm formId;

  public String formValueRefKey;

  public String version;
}