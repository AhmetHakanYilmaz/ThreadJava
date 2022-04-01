class SharedObject implements  Runnable{
    private static final Object LOCK = new Object();
    private static Object o = null;
    private static int retrieveNo;

    public SharedObject(){
        retrieveNo = 0;
    }

    public static int getRetrieveNo() {
        return retrieveNo;
    }

    public static void setRetrieveNo(int retrieveNo) {
        SharedObject.retrieveNo = retrieveNo;
    }

    public static synchronized Object retrieve()  {
        synchronized(LOCK) {
                if (o == null) {
                    o = create();
                }

        return o;
        }
    }



    private static Object create() {
        // mock implementation, would actually return a useful object
        return new Object();
    }

    @Override
    public void run() {
        retrieve();
    }
}