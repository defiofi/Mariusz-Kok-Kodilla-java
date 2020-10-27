package com.kodilla.rps.mechanics;

import java.util.*;

public class RockPaperScissors {
    private Scanner load = new Scanner(System.in);
    private String name = "";
    private int numberOfRounds=0;
    private int winPlayer = 0;
    private int winComputer = 0;

    private Random fate = new Random();
    boolean end = false;
    private Map<Integer , String> mapMovements = new HashMap<>();
    public RockPaperScissors(){
        mapMovements.put(1,"kamień");       /** kamień bije nożyce i jaszczurkę */
        mapMovements.put(2,"papier");       /** papier bije spock i kamień */
        mapMovements.put(3,"nożyce");       /** nożyce biją papier i jaszczurkę */
        mapMovements.put(4,"jaszczurka");   /** jaszczurka bije papier i spock */
        mapMovements.put(5,"spock");        /** spock bije kamień i nożyce */
    }
    public void start(){
        System.out.println("Którą grę uruchomić?:");
        System.out.println("\"Papier, kamień, nożyce\" - naciśnij klawisz 1");
        System.out.println("\"Papier, kamień, nożyce, jaszczurka, spock\" - naciśnij klawisz 2");
        boolean isOk = false;
        int choice = 0;
        while (!isOk) {

            if (load.hasNextInt()) {
                int number = load.nextInt();
                if (number == 1 || number == 2) {
                    choice = number;
                    isOk = true;
                    load.nextLine();        //Czyszczenie bufora
                }
                 else {
                    System.out.println("Wciśnij klawisz 1 lub 2.");
                }
            }
            else {
                load.nextLine();        //Czyszczenie bufora
                System.out.println("Wciśnij klawisz 1 lub 2.");
            }
        }
        if (choice == 1){
            this.begining1();
            this.asking();
            this.game1();
        }
        if (choice == 2){
            this.begining2();
            this.asking();
            this.game2();
        }
    }
    private void begining1(){
        System.out.println("Dzień dobry!\nUruchomiłeś grę: \"Papier, kamień, nożyce\"");
        System.out.println("Zasady gry: \n1. Gra jest dla dwóch graczy. \n" +
                "2. Runda gry polega na równoczesnym zagraniu przez obu graczy jednego z ruchów, tj. kamienia, papieru lub nożyc.");
        System.out.println("  W tym przypadku zagranie nie będzie równoczesne, ponieważ człowiek będzie jako pierwszy wybierał swój ruch.");
        System.out.println("3. Remis następuje w przypadku zagrania tego samego ruchu przez obu graczy.");
        System.out.println("4. Zwycięstwo następuje w przypadku wykonania ruchu bijącego przeciwnika, wedle schematu:");
        System.out.println("- kamień zgniata nożyce,\n- nożyce tną papier, \n- papier przykrywa kamień,");
        System.out.println("5. Po zakończeniu rundy rozpoczyna się kolejną, \n " +
                "aż do osiągnięcia ustalonej liczby wygranych rund przez jednego z graczy.");
    }
    private void begining2(){
        System.out.println("Dzień dobry!\nUruchomiłeś grę: \"Papier, kamień, nożyce, jaszczurka, spock\"");
        System.out.println("Zasady gry: \n1. Gra jest dla dwóch graczy. \n" +
                "2. Runda gry polega na równoczesnym zagraniu przez obu graczy jednego z ruchów," +
                "\nto jest: kamienia, papieru, nożyc, jaszczurki lub spocka.");
        System.out.println("  W tym przypadku zagranie nie będzie równoczesne," +
                "\nponieważ człowiek będzie jako pierwszy wybierał swój ruch.");
        System.out.println("3. Remis następuje w przypadku zagrania tego samego ruchu przez obu graczy.");
        System.out.println("4. Zwycięstwo następuje w przypadku wykonania ruchu bijącego przeciwnika, wedle schematu:");
        System.out.println("- kamień zgniata nożyce i jaszczurkę\n- nożyce tną papier i ranią jaszczurkę" +
                "\n- papier przykrywa kamień i udowadnia błąd spocka\n- jaszczurka zjada papier i zatruwa spocka\n" +
                "- spock kruszy kamień i łamie nożyce.");
        System.out.println("5. Po zakończeniu rundy rozpoczyna się kolejną, \n " +
                "aż do osiągnięcia ustalonej liczby wygranych rund przez jednego z graczy.");
    }
    private void asking(){
        while (name.length()==0) {
            System.out.println("Jak się nazywasz?");
            this.name = load.nextLine();
        }
        boolean isOk = false;
        while (!isOk) {
            System.out.println(name + " po ilu zwycięskich rundach ma nastapić zwyciestwo jednego z graczy?");
            if (load.hasNextInt()) {
                this.numberOfRounds = load.nextInt();
                isOk = true;
            } else {
                load.nextLine();        //Czyszczenie buforu
                System.out.println("Ilość rund musi być liczbą naturalną.");
            }
        }
        System.out.println("Zwyciestwo nastąpi po "+numberOfRounds+" wygranych rundach.");
    }
    private void game1() {
        int playerMove = 0;
        int computerMove = 0;
        int whoWin = 0;     /** whoWin = 0 remis ; whoWin = 1 gracz wygrywa ; whoWin = 2 komputer wygrywa*/
        while (!end){
            showServis1();
            if (load.hasNextInt()){
                int number = load.nextInt();
                if (number>=1&&number<=3){
                    playerMove=number;
                }
                else {
                    System.out.println("Obsługiwane są tylko klawisze: 1 , 2 , 3 , n , x.");
                }
            }
            else{
                String t = load.next();
                if (t.charAt(0) == 'x') {
                    System.out.println("Czy na pewno zakończyć grę?     t/n");
                    String k = load.next();
                    if (k.charAt(0) == 't' || k.charAt(0) == 'T') {
                        System.out.println("Dzięki za grę.");
                        end = true;
                    }
                }
                else if (t.charAt(0) == 'n') {
                    System.out.println("Czy na pewno zakończyć aktualną grę?     t/n");
                    String k = load.next();
                    if (k.charAt(0) == 't' || k.charAt(0) == 'T') {
                        winPlayer = 0;
                        winComputer = 0;
                    }
                }
                else {
                    System.out.println("Obsługiwane są tylko klawisze: 1 , 2 , 3 , n , x.");
                }
            }
            if (playerMove >=1 && playerMove<=3){
                computerMove = fate.nextInt(3) + 1;
                System.out.print("Twój ruch : ");
                System.out.println(mapMovements.get(playerMove));
                System.out.print("Ruch komputera: ");
                System.out.println(mapMovements.get(computerMove));
                whoWin = rate(playerMove, computerMove);
                if (whoWin == 0){
                    System.out.println("runda zakończona remisem");
                }
                else if(whoWin == 1){
                    System.out.println("rundę wygrał "+name);
                    winPlayer +=1;
                }
                else if(whoWin == 2){
                    System.out.println("rundę wygrał komputer");
                    winComputer +=1;
                }
            }
            if (numberOfRounds == winPlayer){
                System.out.println("Gratulacje!\n"+name+" wygrałeś");
                winPlayer = winComputer = 0;
            }
            else if (numberOfRounds==winComputer){
                System.out.println(name+" Tym razem przegrałeś.");
                winPlayer = winComputer = 0;
            }
            playerMove = 0;
            computerMove = 0;
            whoWin = 0;
        }
    }
    private void game2() {
        int playerMove = 0;
        int computerMove = 0;
        int whoWin = 0;     /** whoWin = 0 remis ; whoWin = 1 gracz wygrywa ; whoWin = 2 komputer wygrywa*/
        while (!end){
            showServis2();
            if (load.hasNextInt()){
                int number = load.nextInt();
                if (number>=1&&number<=5){
                    playerMove=number;
                }
                else {
                    System.out.println("Obsługiwane są tylko klawisze: 1 , 2 , 3 , 4 , 5 , n , x.");
                }
            }
            else{
                String t = load.next();
                if (t.charAt(0) == 'x') {
                    System.out.println("Czy na pewno zakończyć grę?     t/n");
                    String k = load.next();
                    if (k.charAt(0) == 't' || k.charAt(0) == 'T') {
                        System.out.println("Dzięki za grę.");
                        end = true;
                    }
                }
                else if (t.charAt(0) == 'n') {
                    System.out.println("Czy na pewno zakończyć aktualną grę?     t/n");
                    String k = load.next();
                    if (k.charAt(0) == 't' || k.charAt(0) == 'T') {
                        winPlayer = 0;
                        winComputer = 0;
                    }
                }
                else {
                    System.out.println("Obsługiwane są tylko klawisze: 1 , 2 , 3 , 4 , 5 , n , x.");
                }
            }
            if (playerMove >=1 && playerMove<=5){
                computerMove = fate.nextInt(5) + 1;
                System.out.print("Twój ruch: ");
                System.out.println(mapMovements.get(playerMove));
                System.out.print("Ruch komputera: ");
                System.out.println(mapMovements.get(computerMove));
                whoWin = rate(playerMove, computerMove);
                if (whoWin == 0){
                    System.out.println("runda zakończona remisem");
                }
                else if(whoWin == 1){
                    System.out.println("rundę wygrał "+name);
                    winPlayer +=1;
                }
                else if(whoWin == 2){
                    System.out.println("rundę wygrał komputer");
                    winComputer +=1;
                }
            }
            if (numberOfRounds == winPlayer){
                System.out.println("Gratulacje!\n"+name+" wygrałeś");
                winPlayer = winComputer = 0;
            }
            else if (numberOfRounds==winComputer){
                System.out.println(name+" Tym razem przegrałeś.");
                winPlayer = winComputer = 0;
            }
            playerMove = 0;
            computerMove = 0;
            whoWin = 0;
        }
    }
    private void showServis1(){
        System.out.println("WYNIK\nZwycięskie rundy: Gracza: "+winPlayer+" Komputera: "+winComputer);
        System.out.println("Obsługa gry:\nklawisz 1 – zagranie \"kamień\",\nklawisz 2 – zagranie \"papier\",");
        System.out.println("klawisz 3 – zagranie \"nożyce\",\nklawisz x – zakończenie gry");
        System.out.println("klawisz n – uruchomienie gry od nowa.\nWciśnij jeden z opisannych klawiszy");
    }
    private void showServis2(){
        System.out.println("WYNIK\nZwycięskie rundy: Gracza: "+winPlayer+" Komputera: "+winComputer);
        System.out.println("Obsługa gry:\nklawisz 1 – zagranie \"kamień\",\nklawisz 2 – zagranie \"papier\",");
        System.out.println("klawisz 3 – zagranie \"nożyce\",\nklawisz 4 - zagranie \"jaszczurka\" ,");
        System.out.println("klawisz 5 - zagranie \"spock\",\nklawisz x – zakończenie gry");
        System.out.println("klawisz n – uruchomienie gry od nowa.\nWciśnij jeden z opisannych klawiszy");
    }
    private int rate(int playerMove, int computerMove){
        /** 0 remis ; 1 gracz wygrywa ; 2 komputer wygrywa
         * '1' kamień bije '3' - nożyce i '4' - jaszczurkę
         * '2' papier bije '5' - spock i '1' - kamień
         * '3' nożyce biją '2' - papier i '4' - jaszczurkę
         * '4' jaszczurka bije '2' - papier i '5' - spock
         * '5' spock bije '1' - kamień i '3' - nożyce */
        if (playerMove == computerMove){
            return 0;
        }
        else if(playerMove == 1 && computerMove == 3) {
            return 1;
        }
        else if(playerMove == 1 && computerMove == 4) {
            return 1;
        }
        else if(playerMove == 2 && computerMove == 1) {
            return 1;
        }
        else if(playerMove == 2 && computerMove == 5) {
            return 1;
        }
        else if(playerMove == 3 && computerMove == 2) {
            return 1;
        }
        else if(playerMove == 3 && computerMove == 4) {
            return 1;
        }
        else if(playerMove == 4 && computerMove == 2) {
            return 1;
        }
        else if(playerMove == 4 && computerMove == 5) {
            return 1;
        }
        else if(playerMove == 5 && computerMove == 1) {
            return 1;
        }
        else if(playerMove == 5 && computerMove == 3) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
