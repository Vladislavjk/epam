package by.training.task04.view;

public class ViewImpl implements View {
    @Override
    public void showMenu(MessageManager messageManager) {
        System.out.println(messageManager.getString("menu"));
    }

    @Override
    public void showAmountOfRegions(MessageManager messageManager) {
        System.out.println(messageManager.getString("regions"));
    }

    @Override
    public void showArea(MessageManager messageManager) {
        System.out.println(messageManager.getString("area"));
    }

    @Override
    public void showRegions(MessageManager messageManager) {
        System.out.println(messageManager.getString("regionsList"));
    }

    @Override
    public void incorrectInput(MessageManager messageManager) {
        System.out.println(messageManager.getString("incorrectInput"));
    }
}
