// neome.ai API - do not change
//

package com.neome.java.api.nucleus.base.dto;

import com.neome.java.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt;
import com.neome.java.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin;
import com.neome.java.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem;
import com.neome.java.api.meta.base.Types.EnumDeviceType;
import com.neome.java.api.meta.base.Types.ServiceName;
import com.neome.java.api.nucleus.base.Types.EnumApiMethod;
import com.neome.java.api.nucleus.base.Types.EnumApiToken;
import com.neome.java.api.nucleus.base.Types.EnumApiVer;
import com.neome.java.api.nucleus.base.Types.EnumArtifactMemberType;
import com.neome.java.api.nucleus.base.Types.EnumConnType;
import com.neome.java.api.nucleus.base.Types.EnumDeployKind;
import com.neome.java.api.nucleus.base.Types.EnumScopeType;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

@SuppressWarnings("unused")
public class SpecApi
{
  public EnumConnType[] allowedConnTypes;

  public EnumDeployKind[] allowedDeployKinds;

  public EnumDeviceType[] allowedDeviceTypes;

  @Nullable
  public String apiDesc;

  public EnumApiMethod apiMethod;

  public String apiName;

  public EnumApiVer apiVer;

  public Set<EnumArtifactMemberType> artifactMembers;

  public boolean canBeAccessedViaDeeplink;

  public boolean internal;

  @Nullable
  public Boolean isDeprecated;

  public boolean logMsg;

  public String module;

  @Nullable
  public String msgClassName;

  @Nullable
  public String msgSchema;

  @Nullable
  public SpecMsg msgSpec;

  public String[] publishes;

  public long rateLimitPerSec;

  public EnumDefnAdminDoNotOptionEnt[] requiredEntAdminScopes;

  public EnumDefnAdminDoNotOptionPlugin[] requiredPluginAdminScopes;

  public EnumDefnAdminDoNotOptionStoreItem[] requiredStoreAdminScopes;

  public String rpcUri;

  public EnumScopeType scope;

  public ServiceName serviceName;

  @Nullable
  public String sigClassName;

  @Nullable
  public String sigSchema;

  public SpecSig sigSpec;

  @Nullable
  public Boolean skipEntLockCheck;

  public boolean skipEntUserAuthorization;

  public boolean skipInputValidation;

  public long sla;

  public long timeout;

  public EnumApiToken token;
}
