// neome.ai API - do not change
//

package com.neome.java.api.meta.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnHttpMethod;
import com.neome.java.api.meta.base.Types.KeychainId;
import com.neome.java.api.meta.base.Types.MetaIdPipelineParam;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EntVdExecuteRpc extends EntVdAutoStepWithOutputAndError
{
  @Nullable
  public EnumDefnHttpMethod apiMethod;

  @Nullable
  public StudioValueText apiName;

  @Nullable
  public MetaIdPipelineParam inputParamId;

  @Nullable
  public FormRefKey outputForm;

  @Nullable
  public KeychainId sendKeychainId;
}
