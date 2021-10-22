import java.util.*;

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private final Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {
        if (contains(elem)) {
            map.replace(elem, map.get(elem) + 1);
            return;
        }
        map.put(elem, 1);
    }

    @Override
    public void remove(E elem) {
        if (contains(elem)) {
            int multiplicity = map.get(elem) - 1;
            if (multiplicity == 0) {
                map.remove(elem);
            } else {
                map.replace(elem, multiplicity);
            }
        }
    }

    @Override
    public void union(Multiset<E> other) {
        other.toSet().forEach(v -> {
            int multiplicity = other.getMultiplicity(v);
            if (map.containsKey(v)) {
                int value = Math.max(map.get(v), multiplicity);
                map.replace(v, value);
            } else {
                map.put(v, multiplicity);
            }
        });
    }

    @Override
    public void intersect(Multiset<E> other) {
        if (other == null) {
            map.clear();
            return;
        }
        Map<E, Integer> m = new HashMap<>(map);
        m.forEach((k, v) -> {
            if (other.contains(k)) {
                int multiplicity = other.getMultiplicity(k);
                int value = v <= multiplicity ? v : multiplicity;
                map.replace(k, value);
            } else {
                map.remove(k);
            }
        });
    }

    @Override
    public int getMultiplicity(E elem) {
        // implement the method
        if (!contains(elem)) {
            return 0;
        }
        return map.get(elem);
    }

    @Override
    public boolean contains(E elem) {
        // implement the method
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        // implement the method
        return map.size();
    }

    @Override
    public int size() {
        // implement the method
        return map.values().stream().reduce(0, Integer::sum);
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
}