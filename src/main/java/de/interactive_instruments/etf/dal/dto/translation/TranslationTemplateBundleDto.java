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
package de.interactive_instruments.etf.dal.dto.translation;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.interactive_instruments.etf.dal.dto.Dto;

/**
 * TranslationTemplateBundleDto represents a bundle of
 * {@link LangTranslationTemplateCollectionDto} that can be accessed through its name.
 *
 * @author J. Herrmann ( herrmann <aT) interactive-instruments (doT> de )
 */
public class TranslationTemplateBundleDto extends Dto {

	/**
	 * Maps a named {@link LangTranslationTemplateCollectionDto#name} to a
	 * language specific collection {@link LangTranslationTemplateCollectionDto}
	 */
	private Map<String, LangTranslationTemplateCollectionDto> langTranslationTemplates;

	// Origin of the templates
	private String source;

	public TranslationTemplateBundleDto() {

	}

	private TranslationTemplateBundleDto(final TranslationTemplateBundleDto other) {
		this.id = other.id;
		this.langTranslationTemplates = other.langTranslationTemplates;
		this.source = other.source;
	}

	/**
	 * Add TranslationTemplates
	 *
	 * @param translationTemplates
	 */
	public void addTranslationTemplates(
			final Collection<TranslationTemplateDto> translationTemplates) {
		if (langTranslationTemplates == null) {
			langTranslationTemplates = new HashMap<>();
		}
		for (final TranslationTemplateDto translationTemplate : translationTemplates) {
			final String name = translationTemplate.getName();
			final LangTranslationTemplateCollectionDto langTranslationTemplateCollection = langTranslationTemplates.get(name);
			if (langTranslationTemplateCollection != null) {
				langTranslationTemplateCollection.add(translationTemplate);
			} else {
				langTranslationTemplates.put(name,
						new LangTranslationTemplateCollectionDto(translationTemplate));
			}
		}
	}

	/**
	 * Returns a LangTranslationTemplateCollectionDto by its name
	 *
	 * @param name Language Translations Template Collections name {@link LangTranslationTemplateCollectionDto#name}
	 * @return
	 */
	public LangTranslationTemplateCollectionDto getTranslationTemplateCollection(final String name) {
		return langTranslationTemplates != null ? langTranslationTemplates.get(name) : null;
	}

	/**
	 * Returns a TranslationTemplate by its name in a specific language
	 *
	 * @param name Translations Template name {@link TranslationTemplateDto#name}
	 * @param language Translations Template language {@link TranslationTemplateDto#language}
	 * @return
	 */
	public TranslationTemplateDto getTranslationTemplate(final String name, String language) {
		final LangTranslationTemplateCollectionDto langTranslationTemplateCollection = getTranslationTemplateCollection(name);
		if (langTranslationTemplateCollection != null) {
			return langTranslationTemplateCollection.getByLanguage(language);
		}
		return null;
	}

	/**
	 * Returns the origin of the Template Bundle as URI
	 *
	 * @return the origin of the Template Bundle as URI
	 */
	public URI getSource() {
		return source != null ? URI.create(source) : null;
	}

	/**
	 * Set the origin of the Template Bundle
	 *
	 * @param source
	 */
	public void setSource(final URI source) {
		this.source = source.toString();
	}

	@Override
	public TranslationTemplateBundleDto createCopy() {
		return new TranslationTemplateBundleDto(this);
	}

}
