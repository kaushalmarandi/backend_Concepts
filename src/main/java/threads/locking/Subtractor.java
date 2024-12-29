package threads.locking;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable {

    Value val;
    Lock lock;

    public Subtractor(Value val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Object call() throws Exception {
        for(int i=0; i<=500; i++){
            lock.lock();
            val.value -=i;
            lock.unlock();
        }
        return null;
    }
}
