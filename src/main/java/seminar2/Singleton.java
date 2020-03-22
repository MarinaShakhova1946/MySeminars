package seminar2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton {

    private static AtomicReference<Singleton> INSTANCE = new AtomicReference<>();
    final int id;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private Singleton(int id) {
        this.id = id;
    }

    public static Singleton getSingleTon(){
        INSTANCE.compareAndSet(null, new Singleton(counter.getAndIncrement()));
        return INSTANCE.get();
    }

    public int getId() {
        return id;
    }
}
