/**
 * Copyright 2017-2018 European Union, interactive instruments GmbH
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 *
 * This work was supported by the EU Interoperability Solutions for
 * European Public Administrations Programme (http://ec.europa.eu/isa)
 * through Action 1.17: A Reusable INSPIRE Reference Platform (ARE3NA).
 */
package de.interactive_instruments.etf.dal.dto.result;

import java.util.List;

public class TestModuleResultDto extends ResultModelItemDto {

	public TestModuleResultDto() {}

	private TestModuleResultDto(final TestModuleResultDto other) {
		super(other);
	}

	public List<TestCaseResultDto> getTestCaseResults() {
		return (List<TestCaseResultDto>) getChildren();
	}

	public void setTestCaseResults(final List<TestCaseResultDto> testCaseResults) {
		setChildren(testCaseResults);
	}

	public void addTestCaseResult(final TestCaseResultDto testCaseResult) {
		addChild(testCaseResult);
	}

	@Override
	public TestModuleResultDto createCopy() {
		return new TestModuleResultDto(this);
	}
}
