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

import de.interactive_instruments.SUtils;
import de.interactive_instruments.etf.model.capabilities.TestObjectType;

/**
 * @author Jon Herrmann ( herrmann aT interactive-instruments doT de )
 */
public class IncompatibleTestObjectType extends Exception {

	private final DetectedTestObjectType detectedTestObjectType;

	private static String labelFor(final DetectedTestObjectType detectedTestObjectType) {
		final StringBuilder sb = new StringBuilder();
		sb.append("'");
		sb.append(detectedTestObjectType.getLabel());
		sb.append("'");
		if (SUtils.isNullOrEmpty(detectedTestObjectType.getExtractedLabel())) {
			sb.append(" (");
			sb.append(detectedTestObjectType.getExtractedLabel());
			sb.append(" )");
		}
		return sb.toString();
	}

	public IncompatibleTestObjectType(final TestObjectType expected, final DetectedTestObjectType detectedTestObjectType) {
		super("Expected a Test Object of type '" +
				expected.getLabel() + "' but detected another type '" + labelFor(detectedTestObjectType)
				+ "' which is also not a subtype of it");
		this.detectedTestObjectType = detectedTestObjectType;
	}
}
