public class GroupSum implements Group<Integer> {
    @Override
    public Integer getNEl() {
        return 0;
    }

    @Override
    public Integer getBinOperation(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer inverse(Integer x) {
        return -x;
    }
}

