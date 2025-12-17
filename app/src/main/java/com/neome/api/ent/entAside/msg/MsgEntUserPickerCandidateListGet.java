// neome.ai API - do not change
//

package com.neome.api.ent.entAside.msg;

import org.jetbrains.annotations.Nullable;

import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.meta.base.Types.MetaIdForm;
import com.neome.api.meta.base.Types.MetaIdRole;
import com.neome.api.meta.base.Types.MetaIdVar;
import com.neome.api.nucleus.base.msg.Msg;

import java.util.Set;

@SuppressWarnings("unused")
public class MsgEntUserPickerCandidateListGet extends Msg
{
  @Nullable
  public FormValueRaw formValueRaw;

  @Nullable
  public Set<MetaIdRole> roleIdSet;

  @Nullable
  public MetaIdVar setOfUserVarId;

  public MetaIdForm sourceFormId;
}
