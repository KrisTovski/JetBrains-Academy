class SuperClassGetter {

    public Class getSuperClassByName(String name) throws ClassNotFoundException {
        // write your code here
        Class n = Class.forName(name);
        return n.getSuperclass();
    }

    public Class getSuperClassByInstance(Object object) {
        // write your code here
        return object.getClass().getSuperclass();
    }
}