package a12030553;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Trainer extends Member {
    private Map < Sports , Level > accreditations = new LinkedHashMap<>();
    public Trainer ( String name , Map < Sports , Level > accreditations ) {
        super(name,accreditations);
        // call super constructor (String , Map <Sports ,Level >)
        this.accreditations.putAll(accreditations);

        // set this . accreditations to a _copy_ ( shallow ) of accreditations argument
    }
    public Map < Sports , Level > getAccreditations () {
        /* returns a _copy_ (shallow ) of this . accreditations */
        return new LinkedHashMap<>(accreditations);
    }
    @Override
    public Set< Sports > getBillableSports () {
        // get billable sports of super (i.e. shallow copy !) and remove all sports that are contained within accreditations ,
        // i.e. trainers don ’t have to pay for the sports they are offering
        // return billable sports for this trainer
        Set<Sports> sport = new LinkedHashSet<Sports>();
        Set<Sports> toDelete = new LinkedHashSet<Sports>();
        for(Sports sporti:super.getBillableSports()){
            if(accreditations.containsKey(sporti)){
                toDelete.add(sporti);
            }
        }
        for(Sports i:super.getBillableSports()){
            if(!toDelete.contains(i)){
                sport.add(i);
            }
        }
        return sport;
    }
    @Override
    public String toString () {
        String toReturn = super.toString() + ", accreditations: {";
        if (!accreditations.isEmpty()) {
            boolean first = true;
            for (Sports key : accreditations.keySet()) {
                if (accreditations.get(key) != null) {
                    if (first) {
                        toReturn += "[" + key.toString() + ", " + accreditations.get(key).toString() + "]";
                        first = false;
                    } else {
                        toReturn += ", [" + key.toString() + ", " + accreditations.get(key).toString() + "]";
                    }
                }
            }
        }
        return toReturn + "}";
    }
}
