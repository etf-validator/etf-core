/**
 * Copyright 2017-2019 European Union, interactive instruments GmbH
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

import java.util.*;

import de.interactive_instruments.Copyable;

/**
 *
 * @author Jon Herrmann ( herrmann aT interactive-instruments doT de )
 */
public class DefaultEidSet<V extends EidHolder> implements EidSet<V> {

    private final Set<V> internalSet;

    public DefaultEidSet() {
        internalSet = new LinkedHashSet<>();
    }

    public DefaultEidSet(final Map<EID, V> map) {
        internalSet = new LinkedHashSet<>(map.values());
    }

    public DefaultEidSet(final Collection<V> collection) {
        internalSet = new LinkedHashSet<>(collection);
    }

    @Override
    public DefaultEidSet<V> createCopy() {
        return new DefaultEidSet(Copyable.createCopy(internalSet));
    }

    public EidSet<V> unmodifiable() {
        return new DefaultEidSet<>(Collections.unmodifiableSet(this));
    }

    @Override
    public EidMap<V> toMap() {
        final Map<EID, V> map = new LinkedHashMap<>();
        internalSet.forEach(i -> map.put(i.getId(), i));
        return new DefaultEidMap<>(map);
    }

    public List<V> toList() {
        return new ArrayList<>(internalSet);
    }

    @Override
    public boolean internalContains(final Object o) {
        return internalSet.contains(o);
    }

    @Override
    public boolean internalRemove(final Object o) {
        return internalSet.remove(o);
    }

    @Override
    public boolean internalContainsAll(final Collection<?> c) {
        return internalSet.containsAll(c);
    }

    @Override
    public boolean internalRetainAll(final Collection<?> c) {
        return internalSet.retainAll(c);
    }

    @Override
    public boolean internalRemoveAll(final Collection<?> c) {
        return internalSet.removeAll(c);
    }

    @Override
    public int size() {
        return internalSet.size();
    }

    @Override
    public boolean isEmpty() {
        return internalSet.isEmpty();
    }

    @Override
    public Iterator<V> iterator() {
        return internalSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return internalSet.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] a) {
        return internalSet.toArray(a);
    }

    @Override
    public boolean add(final V v) {
        return internalSet.add(v);
    }

    @Override
    public boolean addAll(final Collection<? extends V> c) {
        return internalSet.addAll(c);
    }

    @Override
    public void clear() {
        internalSet.clear();
    }

    @Override
    public boolean equals(final Object o) {
        return internalSet.equals(o);
    }

    @Override
    public int hashCode() {
        return internalSet.hashCode();
    }

}
