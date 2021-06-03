package a12030553;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Member implements Comparable < Member > {
    private String name ;
    private Map < Sports , Level > sports = new LinkedHashMap< >();
    public Member ( String name ) {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Member name not valid");
        }
        this.name = name;
    // throws IllegalArgumentException if name is null or empty
    // set this . name
    }
    public Member ( String name , Map < Sports , Level > sportsLevelMap ) {
    // delegate to this constructor ( String )
        this(name);
    // throws IllegalArgumentException if sportsLevelMap is null , empty or contains null - values .
        if(sportsLevelMap == null || sportsLevelMap.size() == 0){
            throw new IllegalArgumentException("Member map not valid1");
        }

        for(Level l: sportsLevelMap.values()){
            if(l == null){
                throw new IllegalArgumentException("Member map not valid");
            }
        }
    // set this . sports to a _copy_ ( shallow ) of sportsLevelMap
        this.sports.putAll(sportsLevelMap);
    }
    public String getName () {return this.name;}
    public Map < Sports , Level > getSports () {return new LinkedHashMap<>(this.sports);}
    public Set< Sports > getBillableSports () {return new LinkedHashSet<>(this.sports.keySet());}
    public Level learn ( Sports newSports , Level newLevel ) {
        // get the member ’s currentLevel of newSports within this . sports
        /* 1) if there is no currentLevel (i.e. null ) ( meaning the Member
                hasn ’t practised the sports yet ), put ( newSports , Level .
                        BEGINNER ) to this . sports Map and return Level . BEGINNER*/
       if(sports.get(newSports) == null){
           sports.put(newSports,Level.BEGINNER);
           return Level.BEGINNER;
       }else{
           if(newLevel.ordinal()-sports.get(newSports).ordinal() >= 1 ){
               Level a = sports.get(newSports).next();
               sports.put(newSports,a);
               return a;
           }
           return sports.get(newSports);
       }
        /*2) if the difference between newLevel and currentLevel is
                greater than or equalto  1 ( meaning the Member tries
                a) to learn the sports way above his/her skills or
                b) the correct next level )
                put ( newSports , currentLevel . next ()) to this . sports
                Map and return the inserted level*/
        // 3) otherwise return the currentLevel
    }
    @Override
    public String toString () {
        // format: "name: %s, sports: %s"

        String toReturn = "name: " + this.name + ", sports: {";
        if (!sports.isEmpty()) {
            boolean first = true;
            for (Sports key : sports.keySet()) {
                if (this.sports.get(key) != null) {
                    if (first) {
                        toReturn += ("[" + key.toString() + ", " + this.sports.get(key).toString()) + "]";
                        first = false;
                    } else {
                        toReturn += ", [" + key.toString() + ", " + this.sports.get(key).toString() + "]";
                    }
                }
            }
        }
        return toReturn + "}";
    }
    @Override
    public int compareTo ( Member member ) {
        /* compare names ( case sensitive )*/
        return this.name.compareTo(member.getName());

    }
    @Override
    public boolean equals ( Object obj ) {
        /* true if names are equal ( case sensitive ) */
        return this.name.equals(((Member)obj).getName()) && obj.getClass() == this.getClass();
    }
    @Override
    public int hashCode () {
        /* return hashCode of name ( case sensitive ) */
        return name.hashCode();
    }
}