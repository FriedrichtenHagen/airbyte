/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.io.airbyte.integration_tests.sources;

import io.airbyte.cdk.integrations.base.ssh.SshHelpers;
import io.airbyte.cdk.integrations.standardtest.source.TestDestinationEnv;
import io.airbyte.commons.json.Jsons;
import io.airbyte.commons.resources.MoreResources;
import io.airbyte.protocol.models.v0.ConnectorSpecification;

public class MySqlStrictEncryptSourceAcceptanceTest extends MySqlSslSourceAcceptanceTest {

  @Override
  protected void setupEnvironment(final TestDestinationEnv environment) throws Exception {
    super.setupEnvironment(environment);
    environmentVariables.set("DEPLOYMENT_MODE", "CLOUD");
  }

  @Override
  protected ConnectorSpecification getSpec() throws Exception {
    return SshHelpers.injectSshIntoSpec(Jsons.deserialize(MoreResources.readResource("expected_cloud_spec.json"), ConnectorSpecification.class));
  }

}
