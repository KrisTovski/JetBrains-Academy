import java.lang.reflect.Method;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {

        String result = "";
        for (String s : classNames) {
            Class clazz = Class.forName(s);
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    result = clazz.getName();
                }
            }
        }

        return result;
    }
}