/*
 * (C) Copyright IBM Corp. 2020, 2022.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.watson.discovery.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.discovery.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

/** Unit test class for the CreateEnrichmentOptions model. */
public class CreateEnrichmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateEnrichmentOptions() throws Throwable {
    EnrichmentOptions enrichmentOptionsModel =
        new EnrichmentOptions.Builder()
            .languages(java.util.Arrays.asList("testString"))
            .entityType("testString")
            .regularExpression("testString")
            .resultField("testString")
            .classifierId("testString")
            .modelId("testString")
            .confidenceThreshold(Double.valueOf("0"))
            .topK(Long.valueOf("26"))
            .build();
    assertEquals(enrichmentOptionsModel.languages(), java.util.Arrays.asList("testString"));
    assertEquals(enrichmentOptionsModel.entityType(), "testString");
    assertEquals(enrichmentOptionsModel.regularExpression(), "testString");
    assertEquals(enrichmentOptionsModel.resultField(), "testString");
    assertEquals(enrichmentOptionsModel.classifierId(), "testString");
    assertEquals(enrichmentOptionsModel.modelId(), "testString");
    assertEquals(enrichmentOptionsModel.confidenceThreshold(), Double.valueOf("0"));
    assertEquals(enrichmentOptionsModel.topK(), Long.valueOf("26"));

    CreateEnrichment createEnrichmentModel =
        new CreateEnrichment.Builder()
            .name("testString")
            .description("testString")
            .type("classifier")
            .options(enrichmentOptionsModel)
            .build();
    assertEquals(createEnrichmentModel.name(), "testString");
    assertEquals(createEnrichmentModel.description(), "testString");
    assertEquals(createEnrichmentModel.type(), "classifier");
    assertEquals(createEnrichmentModel.options(), enrichmentOptionsModel);

    CreateEnrichmentOptions createEnrichmentOptionsModel =
        new CreateEnrichmentOptions.Builder()
            .projectId("testString")
            .enrichment(createEnrichmentModel)
            .file(TestUtilities.createMockStream("This is a mock file."))
            .build();
    assertEquals(createEnrichmentOptionsModel.projectId(), "testString");
    assertEquals(createEnrichmentOptionsModel.enrichment(), createEnrichmentModel);
    assertEquals(
        IOUtils.toString(createEnrichmentOptionsModel.file()),
        IOUtils.toString(TestUtilities.createMockStream("This is a mock file.")));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnrichmentOptionsError() throws Throwable {
    new CreateEnrichmentOptions.Builder().build();
  }
}
