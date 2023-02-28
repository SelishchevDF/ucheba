public class ToDo {

    private ToyListInMachine lm = new ToyListInMachine();
    private ListExtradition le = new ListExtradition();

    public void doSomething(String userSelect){

        UserInputFromConsole input = new UserInputFromConsole();

        if (userSelect.equals("1")) {
            // посмотреть все игрушки
            ConsoleView.print(lm.toyListToString());
            }
        
        else if (userSelect.equals("2")) {
            // добавить игрушку
            String name = input.inputString(Texts.inviteName);
            int weight = 0;
            int quantity = 0;
            while (true) {
                quantity = input.inputInt(Texts.inviteQuantity, Texts.quantityError1);
                if (quantity >= 1) break;
                else ConsoleView.print(Texts.quantityError2); 
            }
            while (true) {
                weight = input.inputInt(Texts.inviteWeight, Texts.weightError1);
                if (weight >= 1 & weight < 100) break;
                else ConsoleView.print(Texts.weightError2); 
            }
            lm.addToy(name, quantity, weight);
        }

        else if (userSelect.equals("3")) {
            // изменить вес игрушки
            int id = input.inputInt(Texts.inviteId, Texts.idError);
            int weight = 0;
            int flag = 0;
            while (true) {
                weight = input.inputInt(Texts.inviteWeight, Texts.weightError1);
                if (weight >= 1 & weight < 100) break;
                else ConsoleView.print(Texts.weightError2);
            }
            for (int i = 0; i < lm.size(); i++) {
                if (lm.get(i).getId() == id) {
                    flag = 1;
                    lm.changeWeight(i, weight, lm);
                }
            }
            if (flag == 0) ConsoleView.print(Texts.noMatches);
        }

        else if (userSelect.equals("4")) {
            // разыграть игрушку
            le.addToyToExtradition(lm.raffle(MyRandome.GetRandom(lm), lm),le);
        }

        else if (userSelect.equals("5")) {
            // посмотреть очередь выдачи
            ConsoleView.print(le.toyListToString());
        }
        
        else if (userSelect.equals("6")) {
            // выдать
            String t = le.extradition(le);
            SaveToTxt.saveAs(t);
            ConsoleView.print(t);

        } 
    }    
}
