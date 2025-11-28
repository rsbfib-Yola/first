public enum Animal {

    CAT("Кошка"), DOG("Собака");

    private String name;

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
