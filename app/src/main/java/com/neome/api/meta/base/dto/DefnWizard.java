// neome.ai API - do not change
//

package com.neome.api.meta.base.dto;

import com.neome.api.meta.base.Types.EnumDefnWizardNavigationMode;
import com.neome.api.meta.base.Types.MetaIdComposite;
import com.neome.api.meta.base.Types.MetaIdWizard;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class DefnWizard extends DefnComp
{
  @Nullable
  public MetaIdComposite[] compositeIdSet;

  public MetaIdWizard metaId;

  @Nullable
  public EnumDefnWizardNavigationMode navigationMode;

  @Nullable
  public String nextButtonLabel;

  @Nullable
  public String prevButtonLabel;
}
