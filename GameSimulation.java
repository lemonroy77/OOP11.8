import java.util.Scanner;

class Player {
    private String name;
    private Alliance alliance;

    public Player(String name) {
        this.name = name;
    }

    public void joinAlliance(Alliance alliance) {
        if (this.alliance != null) {
            this.alliance.removePlayer(this);
        }
        this.alliance = alliance;
        alliance.addPlayer(this);
    }

    public void attack(Player target) {
        if (alliance != null && alliance == target.getAlliance()) {
            System.out.println("Warning: " + name + " and " + target.getName() + " belong to the same alliance and cannot attack each other.");
        } else {
            System.out.println(name + " is attacking " + target.getName() + " from a different alliance.");
        }
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public String getName() {
        return name;
    }
}

class Alliance {
    private String name;
    private Player[] members;
    private int count;

    public Alliance(String name) {
        this.name = name;
        this.members = new Player[10];
        this.count = 0;
    }

    public void addPlayer(Player player) {
        if (count < 10) {
            members[count] = player;
            count++;
            System.out.println(player.getName() + " joined alliance " + name);
        } else {
            System.out.println("Alliance " + name + " is full, cannot add more members.");
        }
    }

    public void removePlayer(Player player) {
        for (int i = 0; i < count; i++) {
            if (members[i] == player) {
                for (int j = i; j < count - 1; j++) {
                    members[j] = members[j + 1];
                }
                members[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public void listMembers() {
        System.out.println("Alliance " + name + " members:");
        for (int i = 0; i < count; i++) {
            System.out.println(members[i].getName());
        }
    }

    public String getName() {
        return name;
    }
}

public class GameSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alliance[] alliances = new Alliance[10];
        Player[] players = new Player[30];
        int allianceCount = 0;
        int playerCount = 0;

        while (true) {
            System.out.print("Enter alliance name: ");
            String allianceName = scanner.next();
            alliances[allianceCount] = new Alliance(allianceName);
            allianceCount++;

            System.out.print("Do you want to continue entering alliance names? (y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                break;
            }
        }

        while (true) {
            System.out.print("Enter player name: ");
            String playerName = scanner.next();
            players[playerCount] = new Player(playerName);
            playerCount++;

            while (true) {
                System.out.print("Join which alliance? ");
                String targetAlliance = scanner.next();
                Alliance selectedAlliance = null;
                for (Alliance alliance : alliances) {
                    if (alliance != null && alliance.getName().equalsIgnoreCase(targetAlliance)) {
                        selectedAlliance = alliance;
                        break;
                    }
                }
                if (selectedAlliance != null) {
                    players[playerCount - 1].joinAlliance(selectedAlliance);
                    break;
                } else {
                    System.out.println("Alliance not found. Please enter a valid alliance name.");
                }
            }

            System.out.print("Do you want to continue entering player names? (y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) {
                break;
            }
        }

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. List alliance members");
            System.out.println("2. Attack a player");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                for (Alliance alliance : alliances) {
                    if (alliance != null) {
                        alliance.listMembers();
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter attacker's name: ");
                String attackerName = scanner.next();
                System.out.print("Enter target's name: ");
                String targetName = scanner.next();

                Player attacker = null;
                Player target = null;
                for (Player player : players) {
                    if (player != null && player.getName().equalsIgnoreCase(attackerName)) {
                        attacker = player;
                    }
                    if (player != null && player.getName().equalsIgnoreCase(targetName)) {
                        target = player;
                    }
                }
                if (attacker != null && target != null) {
                    attacker.attack(target);
                } else {
                    System.out.println("Player not found.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
