package lambda.Worker;

public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;
        Worker worker = new Worker(listener);
        worker.start();
    }
}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}