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
package de.interactive_instruments.etf.detector;

import java.net.URI;

import de.interactive_instruments.Credentials;
import de.interactive_instruments.etf.dal.dto.capabilities.TestObjectTypeDto;
import de.interactive_instruments.etf.model.EidMap;
import de.interactive_instruments.etf.model.capabilities.TestObjectType;

/**
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public interface TestObjectTypeDetector extends Comparable<TestObjectTypeDetector> {

	default int getPriority() {
		return 100;
	}

	TestObjectType detect(final byte[] bytes);

	TestObjectType detect(final URI uri, final Credentials credentials);

	EidMap<TestObjectTypeDto> supportedTypes();

	@Override
	default int compareTo(final TestObjectTypeDetector o) {
		return Integer.compare(getPriority(), o.getPriority());
	}
}
