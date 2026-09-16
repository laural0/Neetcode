public interface Test {
    int test1();
    default int test2(){
        return 1;
    }
}
