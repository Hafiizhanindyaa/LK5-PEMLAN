public enum SecurityLevel {
    PUBLIC(1),
    RESTRICTED(2),
    SECRET(3);
 
    private final int level;
 
    SecurityLevel(int level) {
        this.level = level;
    }
 
    public int getLevel() {
        return level;
    }
}
