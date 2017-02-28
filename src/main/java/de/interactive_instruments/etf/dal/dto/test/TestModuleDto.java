/**
 * Copyright 2010-2017 interactive instruments GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.interactive_instruments.etf.dal.dto.test;

import java.util.Collection;
import java.util.List;

import de.interactive_instruments.etf.dal.dto.MetaDataItemDto;
import de.interactive_instruments.etf.dal.dto.translation.TranslationTemplateBundleDto;

public class TestModuleDto extends TestModelItemDto {

	public TestModuleDto() {}

	private TestModuleDto(final TestModuleDto other) {
		super(other);
	}

	public List<TestCaseDto> getTestCases() {
		return (List<TestCaseDto>) getChildren();
	}

	public void setTestCases(final List<TestCaseDto> testCases) {
		setChildren(testCases);
	}

	public void addTestCase(final TestCaseDto testCase) {
		addChild(testCase);
	}

	@Override
	public TestModuleDto createCopy() {
		return new TestModuleDto(this);
	}
}
