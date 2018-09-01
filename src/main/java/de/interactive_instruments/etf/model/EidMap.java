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
package de.interactive_instruments.etf.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import de.interactive_instruments.Copyable;
import de.interactive_instruments.SUtils;

/**
 * @author Jon Herrmann ( herrmann aT interactive-instruments doT de )
 */
public interface EidMap<V> extends Map<EID, V>, Copyable<EidMap<V>> {
	default Collection asCollection() {
		return values();
	}

	default List asList() {
		return new ArrayList(values());
	}

	EidMap<V> unmodifiable();

	EidMap<V> getAll(final Collection<?> keys);

	void removeAll(final Collection<?> keys);

	/**
	 * Default interface wrapper for searching the eid map directly with strings.
	 *
	 *
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 *
	 * <p>More formally, if this map contains a mapping from a key
	 * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
	 * key.equals(k))}, then this method returns {@code v}; otherwise
	 * it returns {@code null}.  (There can be at most one such mapping.)
	 *
	 * <p>If this map permits null values, then a return value of
	 * {@code null} does not <i>necessarily</i> indicate that the map
	 * contains no mapping for the key; it's also possible that the map
	 * explicitly maps the key to {@code null}.  The {@link #containsKey
	 * containsKey} operation may be used to distinguish these two cases.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or
	 *         {@code null} if this map contains no mapping for the key
	 * @throws ClassCastException if the key is of an inappropriate type for
	 *         this map
	 * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if the specified key is null and this map
	 *         does not permit null keys
	 * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
	 */
	default V get(final Object key) {
		if (key instanceof String) {
			return _internalGet(new SUtils.StrEqContainer(key));
		}
		return _internalGet(key);
	}

	V _internalGet(Object key);

	default V remove(Object key) {
		if (key instanceof String) {
			return _internalRemove(new SUtils.StrEqContainer(key));
		}
		return _internalRemove(key);
	}

	V _internalRemove(Object key);

	default boolean containsKey(Object key) {
		if (key instanceof String) {
			return _internalContainsKey(new SUtils.StrEqContainer(key));
		}
		return _internalContainsKey(key);
	}

	boolean _internalContainsKey(Object key);
}
