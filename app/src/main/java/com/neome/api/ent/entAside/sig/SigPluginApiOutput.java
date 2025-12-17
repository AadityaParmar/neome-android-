// neome.ai API - do not change
//

package com.neome.api.ent.entAside.sig;

import com.neome.api.meta.base.Types.MetaIdField;
import com.neome.api.meta.base.dto.FormValueRaw;
import com.neome.api.nucleus.base.sig.Sig;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class SigPluginApiOutput extends Sig
{
  public FormValueRaw formValueRaw;

  @Nullable
  public Set<MetaIdField> outputFieldIdSet;
}
