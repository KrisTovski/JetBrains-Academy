class Predicate {

    @FunctionalInterface
    public interface TernaryIntPredicate {

        boolean test(int a, int b, int c);

    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (x, y, z) -> x != y && y != z && x != z;

}