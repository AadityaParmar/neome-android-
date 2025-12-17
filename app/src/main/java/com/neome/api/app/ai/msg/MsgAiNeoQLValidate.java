// neome.ai API - do not change
//

package com.neome.api.app.ai.msg;

import com.neome.api.meta.base.Types.MetaIdSpreadsheet;
import com.neome.api.meta.base.dto.FormRefKey;
import com.neome.api.nucleus.base.msg.Msg;

import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class MsgAiNeoQLValidate extends Msg
{
  @Nullable
  public FormRefKey inputFormRefKey;

  public String neoQL;

  @Nullable
  public FormRefKey outputFormRefKey;

  @Nullable
  public Map<String, FormRefKey> paramMap;

  public Set<MetaIdSpreadsheet> spreadsheetIdSet;
}
