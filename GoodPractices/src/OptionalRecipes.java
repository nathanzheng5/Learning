import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class OptionalRecipes {

    // Recipe 1 - never assign null to an optional value / initialize with a null
    public Optional<Employee> getEmployee(int id) {
        Optional<Employee> employee = null;
//        Optional<Employee> employee = Optional.empty();

        // search database

        return employee;
    }

    class Employee {}

    // Recipe 2 - don't call get() directly - throw a NoSuchElementException just like the NullPointerException
    public void printEmployee() {
        Optional<Employee> employee = getEmployee(0);
        System.out.println(employee.get());
//        if (employee.isPresent()) {
//            System.out.println(employee.get());
//        }
    }

    // Recipe 3 - don't use null directly to get a null reference when you have an Optional
    // todo: not sure what this is getting at
    public void callDynamicMethod(MyClass clazz, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Optional<MyClass> instance = clazz.getInstance();
        Method method = instance.getClass().getDeclaredMethod(methodName, String.class);
        if (instance.isPresent()) {
            method.invoke(instance.get(), "test");
        } else {
            method.invoke(null, "test");
        }
//        method.invoke(instance.orElse(null), "test");
    }

    class MyClass {
        public Optional<MyClass> getInstance() {
            return Optional.empty();
        }
    }

    // Recipe 4: avoid using isPresent() and get() pair
    static final String DEFAULT_STATUS = "Unknown";
    public String getEmployeeStatus(long id) {
        Optional<String> status = getStatus(id);
        if (status.isPresent()) {
            return status.get();
        } else {
            return DEFAULT_STATUS;
        }
//        return status.isPresent() ? status.get() : DEFAULT_STATUS;
//        return status.orElse(DEFAULT_STATUS);
        // IMPORTANT: potential performance penalty - the value returned by orElse() is always evaluated,
        // even if the optional is not present!
    }

    private Optional<String> getStatus(long id) {
        return id < 100 ? Optional.of(Long.toString(id)) : Optional.empty();
    }

    // Recipe 5: don't use orElse() for returning a computed value - use orElseGet() with a supplier
    public String getEmployeeStatus2(long id) {
        Optional<String> status = getStatusFromCache(id);
        return status.orElse(getStatusFromDB(id).orElse(""));
//        return status.orElseGet(() -> getStatusFromDB(id).orElse(""));
    }

    private Optional<String> getStatusFromCache(long id) {
        return id < 100 ? Optional.of(Long.toString(id)) : Optional.empty();
    }

    private Optional<String> getStatusFromDB(long id) {
        return id < 10000 ? Optional.of(Long.toString(id)) : Optional.empty();
    }

    // Recipe 6 and 7: throw an exception in the absence of a value - use orElseThrow()
    public Employee findEmployee(int id) throws Exception {
        Optional<Employee> employee = getEmployee(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception();
        }
//        return employee.orElseThrow(Exception::new);
    }

    // Recipe 8: don't use isPresent() / get() pair if you want to perform an action only when an optional value is present - use ifPresent()
    public void useIfPresent() {
        Optional<String> name = Optional.of("Nathan");
        if (name.isPresent()) {
            System.out.println(name.get());
        }
//        name.ifPresent(System.out::println);
    }

    // Recipe 9: don't use isPresent() / get() pair to execute an empty-based action if a value is not present - use ifPresentOrElse()
    // Java 9 feature
    public void useIfPresentOrElse() {
        Optional<String> name = Optional.of("Nathan");
        if (name.isPresent()) {
            System.out.println(name.get());
        } else {
            System.out.println("not found!");
        }
//        name.ifPresentOrElse(() -> System.out.println(name.get()), () -> System.out.println("not found"));
    }


}
