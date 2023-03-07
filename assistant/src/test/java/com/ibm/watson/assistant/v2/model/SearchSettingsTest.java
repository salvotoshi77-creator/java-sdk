/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.watson.assistant.v2.model;

import static org.testng.Assert.*;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.watson.assistant.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

/** Unit test class for the SearchSettings model. */
public class SearchSettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata =
      TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSearchSettings() throws Throwable {
    SearchSettingsDiscoveryAuthentication searchSettingsDiscoveryAuthenticationModel =
        new SearchSettingsDiscoveryAuthentication.Builder()
            .basic("testString")
            .bearer("testString")
            .build();
    assertEquals(searchSettingsDiscoveryAuthenticationModel.basic(), "testString");
    assertEquals(searchSettingsDiscoveryAuthenticationModel.bearer(), "testString");

    SearchSettingsDiscovery searchSettingsDiscoveryModel =
        new SearchSettingsDiscovery.Builder()
            .instanceId("testString")
            .projectId("testString")
            .url("testString")
            .maxPrimaryResults(Long.valueOf("10000"))
            .maxTotalResults(Long.valueOf("10000"))
            .confidenceThreshold(Double.valueOf("0.0"))
            .highlight(true)
            .findAnswers(true)
            .authentication(searchSettingsDiscoveryAuthenticationModel)
            .build();
    assertEquals(searchSettingsDiscoveryModel.instanceId(), "testString");
    assertEquals(searchSettingsDiscoveryModel.projectId(), "testString");
    assertEquals(searchSettingsDiscoveryModel.url(), "testString");
    assertEquals(searchSettingsDiscoveryModel.maxPrimaryResults(), Long.valueOf("10000"));
    assertEquals(searchSettingsDiscoveryModel.maxTotalResults(), Long.valueOf("10000"));
    assertEquals(searchSettingsDiscoveryModel.confidenceThreshold(), Double.valueOf("0.0"));
    assertEquals(searchSettingsDiscoveryModel.highlight(), Boolean.valueOf(true));
    assertEquals(searchSettingsDiscoveryModel.findAnswers(), Boolean.valueOf(true));
    assertEquals(
        searchSettingsDiscoveryModel.authentication(), searchSettingsDiscoveryAuthenticationModel);

    SearchSettingsMessages searchSettingsMessagesModel =
        new SearchSettingsMessages.Builder()
            .success("testString")
            .error("testString")
            .noResult("testString")
            .build();
    assertEquals(searchSettingsMessagesModel.success(), "testString");
    assertEquals(searchSettingsMessagesModel.error(), "testString");
    assertEquals(searchSettingsMessagesModel.noResult(), "testString");

    SearchSettingsSchemaMapping searchSettingsSchemaMappingModel =
        new SearchSettingsSchemaMapping.Builder()
            .url("testString")
            .body("testString")
            .title("testString")
            .build();
    assertEquals(searchSettingsSchemaMappingModel.url(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.body(), "testString");
    assertEquals(searchSettingsSchemaMappingModel.title(), "testString");

    SearchSettings searchSettingsModel =
        new SearchSettings.Builder()
            .discovery(searchSettingsDiscoveryModel)
            .messages(searchSettingsMessagesModel)
            .schemaMapping(searchSettingsSchemaMappingModel)
            .build();
    assertEquals(searchSettingsModel.discovery(), searchSettingsDiscoveryModel);
    assertEquals(searchSettingsModel.messages(), searchSettingsMessagesModel);
    assertEquals(searchSettingsModel.schemaMapping(), searchSettingsSchemaMappingModel);

    String json = TestUtilities.serialize(searchSettingsModel);

    SearchSettings searchSettingsModelNew = TestUtilities.deserialize(json, SearchSettings.class);
    assertTrue(searchSettingsModelNew instanceof SearchSettings);
    assertEquals(
        searchSettingsModelNew.discovery().toString(), searchSettingsDiscoveryModel.toString());
    assertEquals(
        searchSettingsModelNew.messages().toString(), searchSettingsMessagesModel.toString());
    assertEquals(
        searchSettingsModelNew.schemaMapping().toString(),
        searchSettingsSchemaMappingModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchSettingsError() throws Throwable {
    new SearchSettings.Builder().build();
  }
}
