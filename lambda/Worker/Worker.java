package lambda.Worker;

public class Worker {
    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }
}
