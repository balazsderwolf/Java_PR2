package a12030553;

import java.math.BigDecimal;

public enum Sports {
    ARCHERY ,
    BASKETBALL ,
    CLIMBING {
        // due to additional insurance fees , getFeeFactor () returns 1.2
        @Override
        public BigDecimal getFeeFactor() {
            BigDecimal bd = new BigDecimal("1.2");
            return bd;
        }
    } ,
    DIVING {
        // due to renting equipment and insurance , getFeeFactor () returns 1.8

        @Override
        public BigDecimal getFeeFactor() {
            BigDecimal bd = new BigDecimal("1.8");
            return bd;
        }
    } ,
    FOOTBALL ,
    GOLF {
        // due to additional fees for the golf course , getFeeFactor returns 2.1

        @Override
        public BigDecimal getFeeFactor() {
            BigDecimal bd = new BigDecimal("2.1");
            return bd;
        }
    } ,
    HANDBALL ,
    HOCKEY ,
    MOUNTAINBIKING ,
    PARKOUR ;
    public BigDecimal getFeeFactor () {
        BigDecimal bd = new BigDecimal("1.0");
        return bd;
    }
    public BigDecimal getFee ( BigDecimal feePerSports ) {
        return feePerSports.multiply(getFeeFactor());
        // calculate fees depending on sport club ’s feePerSports * feeFactor
    }
}
