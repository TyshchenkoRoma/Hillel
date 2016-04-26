/**
 * Created by roman on 22.04.16.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    public void processUser() {
        int maxIndex = model.getMax(model.array, model.max);
        view.concatenationAndPrint(view.MAX_VALUE, String.valueOf(model.getMax(model.array, model.max)),
                view.MAX_INDEX, String.valueOf(model.getMaxIndex(model.array, maxIndex, model.index)));
    }
}
