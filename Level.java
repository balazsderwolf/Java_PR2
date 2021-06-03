package a12030553;

public enum Level {
    BEGINNER ("Anfänger") ,
    NORMAL ("Normal") ,
    ADVANCED ("Fortgeschritten") ,
    PROFESSIONAL ("Profi") ;
    String mappedName;
    Level(String mapp){
        this.mappedName = mapp;
    }

    public String getMappedName() {
        return mappedName;
    }

    // constructor + getter
    public Level next () {
        // returns next level , last level if no further levels left ( hint : this.ordinal () , Level.values ())
    if(this.ordinal() == 3)
        return this;
    else{
       return Level.values()[(this.ordinal()+1) % Level.values().length];
    }

    }
    @Override
    public String toString () {
        return mappedName;
    }
}
