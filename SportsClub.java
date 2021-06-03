package a12030553;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Map;
public class SportsClub {
    private String name ;
    private BigDecimal feePerSports ;
    private Set < Member > members = new LinkedHashSet< >() ;
    private Map < Sports , Set < Trainer > > offeredSports = new LinkedHashMap<>() ;
    public SportsClub ( String name , BigDecimal feePerSports ) {
        // throws IllegalArgumentException if name is null or empty
        if( name == null || name.length() == 0)
            throw new IllegalArgumentException("SportsClub name not valid");
        if(feePerSports == null)
            throw new IllegalArgumentException("feePerSPorts is null");
        // throws IllegalArgumentException if feePerSports is null
        // set member variables
        this.name = name;
        this.feePerSports = feePerSports;
    }
    public String getName () {return this.name;}
    public BigDecimal getFeePerSports () {return this.feePerSports;}
    public Set < Member > getMembers () {return new LinkedHashSet<>(this.members);}
    public Set < Sports > getSports () {
        return new LinkedHashSet<>(offeredSports.keySet());
    }
    public BigDecimal calculateMembershipFee ( Member member ) {
        // throw IllegalArgumentException if member is no member of this sports club
        if(!members.contains(member)){
            throw new IllegalArgumentException("No member in club");
        }
        BigDecimal result = new BigDecimal("0");

        for(Sports one : member.getBillableSports()){
            if(offeredSports.containsKey(one)){
                result = result.add(one.getFee(feePerSports));
            }
        }
        // get member ’s billable sports and filter the member ’s billable sports according to this . offeredSports
        // i.e. the sports club is only allowed to bill sports that are offered
        // based on the filtered sports list , return accumulated fees using Sports . getFee ( BigDecimal ) method using this . feePerSports

        return result;
    }
    public boolean registerSports ( Member member , Sports sports , Level level ) {
        // throw IllegalArgumentException if member is no member of this sports club
        if(!members.contains(member)){
            throw new IllegalArgumentException("No member in club");
        }
        // register a member for a sports course for a specific level :
        // 1. check whether there is a trainer available for the given sports that has an accreditation greater or equal to level
        boolean isThere = false;
        if(offeredSports.get(sports) != null){
            for(Trainer t : offeredSports.get(sports)){
                if(t.getAccreditations().get(sports).ordinal() >= level.ordinal()){
                    isThere = true;
                }
            }
        }
        if(!isThere){
            return false;
        }else{
            if(member.learn(sports,level) == level){
                return true;
            }else{
                return false;
            }
        }
        // 2. return false if there is no trainer available
        // 3. let the member learn the sports using Member . learn (...) and return true if he/she was successful to learn at the specifiedlevel , false otherwise
    }
    public boolean addMember ( Member member ) {
        // if the member is a Trainer ( check using ’ instanceof ’ keyword )
        // add the trainer ’s accreditations to the sport club ’s offeredSports map , adding the trainer to the Set ( value ) of the map.
        // return whether the member was added to the this . members set or not
        if (member instanceof Trainer) {
            for (Sports sport : ((Trainer) member).getAccreditations().keySet()){
                if (!offeredSports.containsKey(sport))
                    offeredSports.put(sport, new LinkedHashSet<Trainer>());
                offeredSports.get(sport).add((Trainer) member);
            }
        }
        return this.members.add(member);
    }
    public boolean removeMember ( Member member ) {
            // if the member is a Trainer ( check using ’ instanceof ’ keyword )
            // - remove the trainer from the sport club ’s offeredSports -Map (Values )
            // - if the trainer was the only Trainer for a sports , remove the key from the offeredSports
            // return true if the member was successfully removed from this . members
        if (member instanceof Trainer){
            Set<Sports> toDelete = new LinkedHashSet<>();
            for (Sports key : offeredSports.keySet()){
                offeredSports.get(key).remove(member);
                if (offeredSports.get(key).isEmpty())
                    toDelete.add(key);
            }
            for(Sports k : toDelete){
                offeredSports.remove(k);
            }
        }
        return members.remove(member);
    }
    @Override
    public String toString () {
        // format: SportsClub[name: %s, feePerSports: %s, offeredSports: % s]
        String toReturn = "SportsClub[name: " + this.name + ", feePerSports: " + feePerSports + ", offeredSports: {";
        boolean first = true;
        for (Sports key : offeredSports.keySet()){
            if (first){
                toReturn += key.toString();
                first = false;
            } else
                toReturn += ", " + key.toString();
        }
        toReturn += "}]";
        return toReturn;
    }

}
