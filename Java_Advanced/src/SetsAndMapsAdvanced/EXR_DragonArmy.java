package SetsAndMapsAdvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXR_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //Pattern pattern = Pattern.compile("(?<type>[A-Z][a-z]+)\\s(?<name>[A-Z][a-z]+)\\s(?<damage>\\w+)\\s(?<health>\\w+)\\s(?<armor>\\w+)");

        LinkedHashMap<String, List<DragonData>> dragonMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            //Matcher matcher = pattern.matcher(input);
            //while(matcher.find()){

            String[] dataInput = input.split("\\s+");
//                String type = matcher.group("type");
//                String name = matcher.group("name");
//                String damage = matcher.group("damage");
//                String health = matcher.group("health");
//                String armor = matcher.group("armor");

            String type = dataInput[0];
            String name = dataInput[1];
            String damage = dataInput[2];
            String health = dataInput[3];
            String armor = dataInput[4];

            if (damage.equals("null")) {
                damage = "45";
            }
            if (health.equals("null")) {
                health = "250";
            }
            if (armor.equals("null")) {
                armor = "10";
            }
            DragonData dragonData = new DragonData(name, Integer.parseInt(damage), Integer.parseInt(health), Integer.parseInt(armor));

            if (dragonMap.containsKey(type)) {
                boolean dragonExist = false;
                for (DragonData data : dragonMap.get(type)) {
                    if (data.getName().equals(name)) {
                        data.setArmor(Integer.parseInt(armor));
                        data.setDamage(Integer.parseInt(damage));
                        data.setHealth(Integer.parseInt(health));
                        dragonExist = true;
                        break;
                    }
                }
                if (!dragonExist) {
                    dragonMap.get(type).add(dragonData);
                }
            } else {
                dragonMap.put(type, new ArrayList<>());
                dragonMap.get(type).add(dragonData);
            }
            //}
        }

        dragonMap.forEach((key, value) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, value.stream().mapToDouble(DragonData::getDamage).average().getAsDouble(),
                    value.stream().mapToDouble(DragonData::getHealth).average().getAsDouble(),
                    value.stream().mapToDouble(DragonData::getArmor).average().getAsDouble());

            value.stream()
                    .sorted(Comparator.comparing(DragonData::getName))
                    .forEach(el -> {
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", el.getName(), el.getDamage(), el.getHealth(), el.getArmor());
                    });
        });

    }


    public static class DragonData {
        private String name;
        private int damage;
        private int health;
        private int armor;

        public DragonData(String name, int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

    }
}
