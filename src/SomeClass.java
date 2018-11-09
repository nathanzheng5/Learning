/**
 * TODO: CLASS JAVA DOC HERE
 */
public class SomeClass {

    private final String a;
    private final int b;
    private final double c;

    public SomeClass(String a, int b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeClass someClass = (SomeClass) o;

        if (b != someClass.b) return false;
        if (Double.compare(someClass.c, c) != 0) return false;
        return a.equals(someClass.a);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = a.hashCode();
        result = 31 * result + b;
        temp = Double.doubleToLongBits(c);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
