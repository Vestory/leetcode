public class Timer {

    private long startTime;
    private long lastTime;

    public Timer() {
        startTime = System.currentTimeMillis();
        lastTime = startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public long getSpan() {
        return System.currentTimeMillis() - startTime;
    }

    public void stamp() {
        long time = System.currentTimeMillis();
        System.out.println("From start: " + (time - startTime) + "ms\nFrom Last: " + (time - lastTime) + "ms");
        lastTime = time;
    }
}