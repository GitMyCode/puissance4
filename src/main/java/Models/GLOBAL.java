package Models;

/**
 * Created by Martin on 4/2/14.
 *
 * http://javahowto.blogspot.ca/2008/04/java-enum-examples.html
 */
public abstract class GLOBAL {

    public static final int AI=0;
    public static final int HUMAN=1;
    public static final int RED=2;
    public static final int YELLOW=3;
    public static final int FREE=4;

    /*
    * GAMESTATE
    * */

    public static final int IN_GAME=5;
    public static final int GAME_FULL=6;

   public static final String action_AI = "AI";
   public static final String action_HUMAN = "HUMAN";
   public static final String action_PLAYER1 = "PLAYER1";
   public static final String action_PLAYER2 = "PLAYER2";
   public static final String action_COULISSE= "COULISSE";
   public static final String action_EXACT = "EXACT";



    /*
    AI(0,"AI"),
    HUMAN(1 , "HUMAN"),
    IN_GAME(2,"IN_GAME"),

    RED(3,"RED"),
    YELLOW(4,"YELLOW"),
    FREE(5,"FREE");








    private int code;
    private String action_command;

    /**
     * A mapping between the integer code and its corresponding GLOBAL to facilitate lookup by code.
     */
    /*
    private static Map<Integer, GLOBAL> codeToStatusMapping;

    private GLOBAL(int code, String action_command) {
        this.code = code;
        this.action_command = action_command;
    }

    public static GLOBAL getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }

    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, GLOBAL>();
        for (GLOBAL s : values()) {
            codeToStatusMapping.put(s.code, s);
        }
    }

    public int getCode() {
        return code;
    }

    public String getAction_command() {
        return action_command;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("GLOBAL");
        sb.append("{code=").append(code);
        sb.append(", action_command='").append(action_command).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(GLOBAL.AI);
        System.out.println(GLOBAL.getStatus(-1));
    }
    */

}
