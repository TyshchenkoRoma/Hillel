import java.util.Date;

/**
 * Created by roman on 03.06.16.
 */
public class Main {
    public static void main(String[] args) {
        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("неподдерживаемая производственная линия часов " + maker);

    }
}

interface Watch {
    void showTime();
}

class DigitaWatsh implements Watch {
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatsh implements Watch {
    @Override
    public void showTime() {
        System.out.println("XII - XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitaWatsh();
    }
}

class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatsh();
    }
}