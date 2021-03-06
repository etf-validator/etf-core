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
package de.interactive_instruments.etf.dal.dto.capabilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import de.interactive_instruments.UriUtils;
import de.interactive_instruments.etf.dal.dto.MetaDataItemDto;
import de.interactive_instruments.etf.model.ExpressionType;
import de.interactive_instruments.etf.model.capabilities.TestObjectType;

/**
 * A Test Object Type describes a {@link TestObjectDto} and may possess
 * information how the type can be detected.
 *
 * @author Jon Herrmann ( herrmann aT interactive-instruments doT de )
 */
public class TestObjectTypeDto extends MetaDataItemDto<TestObjectTypeDto> implements TestObjectType {

	private List<TestObjectTypeDto> subTypes;

	// Optional list of supported filenameExtensions
	private List<String> filenameExtensions;

	// Optional list of supported mimetypes
	private List<String> mimeTypes;

	// Optional detection expression
	private String detectionExpression;

	// Optional detection expression type
	private ExpressionType detectionExpressionType;

	// Optional expression for extracting the Test Object label
	private String labelExpression;

	// Optional expression for extracting the Test Object label type
	private ExpressionType labelExpressionType;

	// Optional expression for extracting the Test Object description
	private String descriptionExpression;

	// Optional expression for extracting the Test Object description type
	private ExpressionType descriptionExpressionType;

	// Optional default query (only used in remote resources yet)
	private String defaultPathAndQuery;

	// Optional regular expression to detect a type from an URI.
	private String uriDetectionExpression;

	// Optional naming convention, which is used to
	// check if the label of a Test Object matches this regular expression.
	// This might be useful for labeling test data deliveries according
	// to a prescribed scheme.
	private String namingConvention;

	public TestObjectTypeDto() {}

	private TestObjectTypeDto(final TestObjectTypeDto other) {
		super(other);
		this.subTypes = other.subTypes;
		this.filenameExtensions = other.filenameExtensions;
		this.mimeTypes = other.mimeTypes;
		this.detectionExpression = other.detectionExpression;
		this.detectionExpressionType = other.detectionExpressionType;
		this.labelExpression = other.labelExpression;
		this.labelExpressionType = other.labelExpressionType;
		this.descriptionExpression = other.descriptionExpression;
		this.descriptionExpressionType = other.descriptionExpressionType;
		this.defaultPathAndQuery = other.defaultPathAndQuery;
		this.uriDetectionExpression = other.uriDetectionExpression;
		this.namingConvention = other.namingConvention;
	}

	public List<TestObjectTypeDto> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(final List<TestObjectTypeDto> subTypes) {
		this.subTypes = subTypes;
	}

	public void addSubType(final TestObjectTypeDto subType) {
		if (this.subTypes == null) {
			subTypes = new ArrayList<>();
		}
		subTypes.add(subType);
	}

	public String getNamingConvention() {
		return namingConvention;
	}

	public void setNamingConvention(final String namingConvention) {
		this.namingConvention = namingConvention;
	}

	public List<String> getFilenameExtensions() {
		return filenameExtensions;
	}

	public void setFilenameExtensions(final List<String> filenameExtensions) {
		this.filenameExtensions = filenameExtensions;
	}

	public void setFilenameExtensions(final String... filenameExtensions) {
		this.filenameExtensions = Arrays.asList(filenameExtensions);
	}

	public List<String> getMimeTypes() {
		return mimeTypes;
	}

	public void setMimeTypes(final List<String> mimeTypes) {
		this.mimeTypes = mimeTypes;
	}

	public void setDetectionExpression(final String detectionExpression, final ExpressionType type) {
		this.detectionExpression = detectionExpression;
		this.descriptionExpressionType = type;
	}

	public String getDetectionExpression() {
		return detectionExpression;
	}

	public ExpressionType getDetectionExpressionType() {
		return detectionExpressionType;
	}

	public void setLabelExpression(final String labelExpression, final ExpressionType type) {
		this.labelExpression = labelExpression;
		this.labelExpressionType = type;

	}

	public void setDefaultPathAndQuery(final String defaultPathAndQuery) {
		this.defaultPathAndQuery = defaultPathAndQuery;
	}

	public Map<String, List<String>> getDefaultQuery() {
		if (defaultPathAndQuery != null) {
			return UriUtils.getQueryParameters(defaultPathAndQuery);
		}
		return null;
	}

	public String getDefaultAccessPath() {
		return UriUtils.withoutQueryParameters(defaultPathAndQuery);
	}

	public void setUriDetectionExpression(final String uriDetectionExpression) {
		this.uriDetectionExpression = Pattern.compile(uriDetectionExpression).pattern();
	}

	public String getUriDetectionExpression() {
		return uriDetectionExpression;
	}

	public String getLabelExpression() {
		return labelExpression;
	}

	public ExpressionType getLabelExpressionType() {
		return labelExpressionType;
	}

	public void setDescriptionExpression(final String descriptionExpression, final ExpressionType type) {
		this.descriptionExpression = descriptionExpression;
		this.descriptionExpressionType = type;
	}

	public String getDescriptionExpression() {
		return descriptionExpression;
	}

	public ExpressionType getDescriptionExpressionType() {
		return descriptionExpressionType;
	}

	@Override
	public TestObjectTypeDto createCopy() {
		return new TestObjectTypeDto(this);
	}
}
