package a12030553;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Map<String,Boolean> resultMap=new LinkedHashMap<>();
        {
            //Test1 check Sports enum names
            Boolean result=true;
            String[] sportStringArray={"ARCHERY", "BASKETBALL","CLIMBING","DIVING",
                    "FOOTBALL","GOLF","HANDBALL","HOCKEY","MOUNTAINBIKING","PARKOUR"};
            Sports[] sportsArray=Sports.values();
            for(int i=0;i<sportStringArray.length;++i) {
                if(!sportStringArray[i].equals(sportsArray[i].toString()))result=false;
            }
            resultMap.put("Test1 check Sports enum names", result);
        }
        {
            //Test2 check geetFeeFactor and getFee
            Boolean result=true;
            Sports[] sportsArray=Sports.values();
            for(int i=0;i<sportsArray.length;++i) {
                if(sportsArray[i].equals(Sports.CLIMBING)) {
                    if(!(sportsArray[i].getFeeFactor().compareTo(new BigDecimal("1.2"))==0))result=false;
                    if(!(sportsArray[i].getFee(new BigDecimal("47.23425253346353")).compareTo(new BigDecimal("56.681103040156236"))==0))result=false;
                }
                else if(sportsArray[i].equals(Sports.DIVING)) {
                    if(!(sportsArray[i].getFeeFactor().compareTo(new BigDecimal("1.8"))==0))result=false;
                    if(!(sportsArray[i].getFee(new BigDecimal("12.3456")).compareTo(new BigDecimal("22.22208"))==0))result=false;
                }else if(sportsArray[i].equals(Sports.GOLF)) {
                    if(!(sportsArray[i].getFeeFactor().compareTo(new BigDecimal("2.1"))==0))result=false;
                    if(!(sportsArray[i].getFee(new BigDecimal("54.321")).compareTo(new BigDecimal("114.0741"))==0))result=false;
                }else {
                    if(!(sportsArray[i].getFeeFactor().compareTo(new BigDecimal("1.0"))==0))result=false;
                    if(!(sportsArray[i].getFee(new BigDecimal("108.15")).compareTo(new BigDecimal("108.15"))==0))result=false;
                }

            }
            resultMap.put("Test2 check geetFeeFactor and getFee", result);

        }
        {
            //Test3 check Level Enums name
            Boolean result=true;
            String[] levelStringArray={"Anfänger", "Normal", "Fortgeschritten", "Profi"};
            Level[] levelArray=Level.values();
            for(int i=0;i<levelStringArray.length;++i) {
                if(!levelStringArray[i].equals(levelArray[i].toString()))result=false;
            }
            resultMap.put("Test3 check Level Enums name", result);

        }
        {
            //Test4 Level enum next Test
            Boolean result=true;
            if(!Level.BEGINNER.next().equals(Level.NORMAL))result=false;
            if(!Level.NORMAL.next().equals(Level.ADVANCED))result=false;
            if(!Level.ADVANCED.next().equals(Level.PROFESSIONAL))result=false;
            if(!Level.PROFESSIONAL.next().equals(Level.PROFESSIONAL))result=false;
            resultMap.put("Test4 Level enum next Test", result);
        }
        {
            //Test5 Member construktor
            Boolean result=true;
            try {
                Member m=new Member("");
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Member m=new Member(null);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Member m=new Member("name");
                if(!m.getName().equals("name"))result=false;
                if(m.getSports().size()!=0)result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Member m=new Member("name",null);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                Member m=new Member("name",map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                map.put(Sports.CLIMBING, null);
                map.put(Sports.FOOTBALL, Level.ADVANCED);
                Member m=new Member("name",map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Member m=new Member("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=1)result=false;
                if(!m.getBillableSports().contains(Sports.ARCHERY))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new LinkedHashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Member m=new Member("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=1)result=false;
                if(!m.getBillableSports().contains(Sports.ARCHERY))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new TreeMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Member m=new Member("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=1)result=false;
                if(!m.getBillableSports().contains(Sports.ARCHERY))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new ConcurrentHashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Member m=new Member("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=1)result=false;
                if(!m.getBillableSports().contains(Sports.ARCHERY))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            resultMap.put("Test5 Member construktor", result);
        }
        {
            //Test6 getSports and getBillableSports
            Boolean result=true;
            Map<Sports,Level> map=new HashMap<>();
            Random rand=new Random();
            for(int i=0;i<Sports.values().length;++i) {
                int randomInteger = rand.nextInt(4);
                map.put(Sports.values()[i], Level.values()[randomInteger]);
                map.put(Sports.values()[i], Level.values()[randomInteger]);
            }
            Member m=new Member("Member",map);
            map.clear();
            m.getSports().clear();
            if(m.getSports().size()!=Sports.values().length)result=false;
            if(m.getBillableSports().size()!=Sports.values().length)result=false;
            map.put(Sports.MOUNTAINBIKING, Level.ADVANCED);
            Member m2=new Member("Member2",map);
            if(m2.getSports().size()!=1)result=false;
            if(m2.getBillableSports().size()!=1)result=false;
            if(!m2.getSports().containsKey(Sports.MOUNTAINBIKING))result=false;
            if(!m2.getSports().containsValue(Level.ADVANCED))result=false;
            if(!m.getBillableSports().contains(Sports.MOUNTAINBIKING))result=false;
            resultMap.put("Test6 getSports and getBillableSports", result);

        }
        {
            //Test7 Member learn
            Boolean result=true;
            Member m=new Member("Member");
            if(m.getSports().size()!=0)result=false;
            if(!Level.BEGINNER.equals(m.learn(Sports.ARCHERY, Level.PROFESSIONAL)))result=false;
            if(m.getSports().get(Sports.ARCHERY)!=null) {
                if(!m.getSports().get(Sports.ARCHERY).equals(Level.BEGINNER))result=false;
            }else result=false;
            if(!Level.BEGINNER.equals(m.learn(Sports.BASKETBALL, Level.BEGINNER)))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!m.getSports().get(Sports.BASKETBALL).equals(Level.BEGINNER))result=false;
            }else result=false;
            if(!Level.BEGINNER.equals(m.learn(Sports.BASKETBALL, Level.BEGINNER)))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!m.getSports().get(Sports.BASKETBALL).equals(Level.BEGINNER))result=false;
            }else result=false;
            if(!Level.NORMAL.equals(m.learn(Sports.BASKETBALL, Level.NORMAL)))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!m.getSports().get(Sports.BASKETBALL).equals(Level.NORMAL))result=false;
            }else result=false;
            if(m.getSports().size()!=2)result=false;
            if(!Level.NORMAL.equals(m.learn(Sports.BASKETBALL, Level.BEGINNER)))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!m.getSports().get(Sports.BASKETBALL).equals(Level.NORMAL))result=false;
            }else result=false;
            if(m.getSports().size()!=2)result=false;
            //if(!m.toString().equals("name: Member, sports: {ARCHERY=Anfänger, BASKETBALL=Normal}"))result=false;
            resultMap.put("Test7 Member learn", result);
        }
        {
            //Test8 Member compareTo, equals and hachcode
            Boolean result=true;
            Map<Sports, Level> map=new HashMap<>();
            map.put(Sports.ARCHERY, Level.ADVANCED);
            Member m=new Member("A",map);
            if(m.compareTo(m)!=0)result=false;
            if(!m.equals(m))result=false;
            Member m2=new Member("A",map);
            if(m.compareTo(m2)!=0)result=false;
            if(!m.equals(m2))result=false;
            if(m.hashCode()!=m2.hashCode())result=false;
            Member m3=new Member("B",map);
            if(m.equals(m3))result=false;
            if(m.compareTo(m3)==0)result=false;
            if(m.hashCode()==m3.hashCode())result=false;
            Member t=new Trainer("A",map);
            //if(t.compareTo(m)==0)result=false;//Wrong
            if(t.equals(m))result=false;
            //if(t.hashCode()==m.hashCode())result=false;//Wrong
            resultMap.put("Test8 Member compareTo, equals and hachcode", result);
        }


        {
            //Test9 Trainer construktor
            Boolean result=true;
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("",map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer(null,map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("name",map);
                if(!m.getName().equals("name"))result=false;
                if(m.getSports().size()!=1)result=false;
                if(m.getAccreditations().size()!=1)result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Trainer m=new Trainer("name",null);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                Trainer m=new Trainer("name",map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                map.put(Sports.CLIMBING, null);
                map.put(Sports.FOOTBALL, Level.ADVANCED);
                Trainer m=new Trainer("name",map);
                result=false;
                m.equals(m);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                Map<Sports,Level> map=new HashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=0)result=false;
                if(m.getAccreditations().size()!=1)result=false;
                if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
                if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new LinkedHashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=0)result=false;
                if(m.getAccreditations().size()!=1)result=false;
                if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
                if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new TreeMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=0)result=false;
                if(m.getAccreditations().size()!=1)result=false;
                if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
                if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            try {
                Map<Sports,Level> map=new ConcurrentHashMap<>();
                map.put(Sports.ARCHERY, Level.BEGINNER);
                Trainer m=new Trainer("name",map);
                map.clear();
                if(!m.getName().equals("name"))result=false;
                if(m.getBillableSports().size()!=0)result=false;
                if(m.getAccreditations().size()!=1)result=false;
                if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
                if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
                if(m.getSports().size()!=1)result=false;
                if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
                if(!m.getSports().containsValue(Level.BEGINNER))result=false;
            }catch(Exception e) {
                result=false;
            }
            resultMap.put("Test9 Trainer construktor", result);
        }
        {
            //Test10 Trainer getAccreditations()
            boolean result=true;
            Map<Sports,Level> map=new HashMap<>();
            map.put(Sports.ARCHERY, Level.BEGINNER);
            Trainer m=new Trainer("name",map);
            m.getAccreditations().clear();
            if(m.getAccreditations().size()!=1)result=false;
            if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
            if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
            resultMap.put("Test10 Trainer getAccreditations()", result);
        }
        {
            //Test11 Trainer getBillableSports()
            boolean result=true;
            Map<Sports,Level> map=new HashMap<>();
            map.put(Sports.ARCHERY, Level.BEGINNER);
            Trainer m=new Trainer("name",map);
            m.learn(Sports.BASKETBALL, Level.ADVANCED);
            m.getBillableSports().clear();
            if(m.getBillableSports().size()!=1)result=false;
            if(!m.getBillableSports().contains(Sports.BASKETBALL))result=false;
            if(m.getAccreditations().size()!=1)result=false;
            if(!m.getAccreditations().containsKey(Sports.ARCHERY))result=false;
            if(!m.getAccreditations().containsValue(Level.BEGINNER))result=false;
            if(m.getSports().size()!=2)result=false;
            if(!m.getSports().containsKey(Sports.ARCHERY))result=false;
            if(!m.getSports().get(Sports.ARCHERY).equals(Level.BEGINNER))result=false;
            if(!m.getSports().containsKey(Sports.BASKETBALL))result=false;
            if(!m.getSports().get(Sports.BASKETBALL).equals(Level.BEGINNER))result=false;
            resultMap.put("Test11 Trainer getBillableSports()", result);

        }
        {
            //Test12 SportsClub constructor test
            boolean result=true;
            try {
                SportsClub sc=new SportsClub("",new BigDecimal("12"));
                result=false;
                sc.equals(sc);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                SportsClub sc=new SportsClub(null,new BigDecimal("12"));
                result=false;
                sc.equals(sc);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                SportsClub sc=new SportsClub("SC",null);
                result=false;
                sc.equals(sc);//only for warning
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            try {
                SportsClub sc=new SportsClub("SC",new BigDecimal("12.10"));
                if(!sc.getName().equals("SC"))result=false;
                if(!(sc.getFeePerSports().compareTo(new BigDecimal("12.1"))==0))result=false;
                if(sc.getMembers().size()!=0)result=false;
                if(sc.getSports().size()!=0)result=false;
            }catch(Exception e) {
                result=false;
            }
            resultMap.put("Test12 SportsClub constructor test", result);
        }
        {
            //Test13 SportsClub getMembers()
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.0"));
            Map<Sports,Level> mappyMcMapFace=new HashMap<>();
            mappyMcMapFace.put(Sports.PARKOUR, Level.NORMAL);
            Member m=new Member("Member",mappyMcMapFace);
            mappyMcMapFace.clear();
            mappyMcMapFace.put(Sports.CLIMBING, Level.ADVANCED);
            Trainer t=new Trainer("Trainer",mappyMcMapFace);
            sc.addMember(m);
            sc.addMember(t);
            sc.getMembers().clear();
            if(sc.getMembers().size()!=2)result=false;
            if(!sc.getMembers().contains(m))result=false;
            if(!sc.getMembers().contains(t))result=false;
            resultMap.put("Test13 SportsClub getMembers()", result);
        }
        {
            //Test14 SportsClub test getFeePerSports()
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.0"));
            BigDecimal x=sc.getFeePerSports();
            x=new BigDecimal("84.0");
            x.equals(x);//only for warning
            x=null;
            if(!(sc.getFeePerSports().compareTo(new BigDecimal("42.0"))==0))result=false;
            resultMap.put("Test14 SportsClub test getFeePerSports()", result);
        }
        {
            //Test15 SportsClub getSports() (no test for shallow copy here because i return a View)
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.0"));
            Map<Sports,Level> mappyMcMapFace=new HashMap<>();
            mappyMcMapFace.put(Sports.PARKOUR, Level.NORMAL);
            mappyMcMapFace.put(Sports.CLIMBING, Level.ADVANCED);
            Member t1=new Trainer("Trainer1",mappyMcMapFace);
            mappyMcMapFace.clear();
            mappyMcMapFace.put(Sports.HOCKEY, Level.PROFESSIONAL);
            Trainer t2=new Trainer("Trainer2",mappyMcMapFace);
            t1.learn(Sports.ARCHERY, Level.BEGINNER);
            t2.learn(Sports.DIVING, Level.NORMAL);
            mappyMcMapFace.clear();
            mappyMcMapFace.put(Sports.HANDBALL, Level.NORMAL);
            Member m=new Member("Member",mappyMcMapFace);
            sc.addMember(t1);
            sc.addMember(t2);
            sc.addMember(m);
            if(sc.getSports().size()!=3)result=false;
            if(!sc.getSports().contains(Sports.PARKOUR))result=false;
            if(!sc.getSports().contains(Sports.CLIMBING))result=false;
            if(!sc.getSports().contains(Sports.HOCKEY))result=false;
            if(sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.DIVING))result=false;
            if(sc.getSports().contains(Sports.HANDBALL))result=false;
            sc.removeMember(t1);
            if(sc.getSports().size()!=1)result=false;
            if(!sc.getSports().contains(Sports.HOCKEY))result=false;
            if(sc.getSports().contains(Sports.PARKOUR))result=false;
            if(sc.getSports().contains(Sports.CLIMBING))result=false;
            if(sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.DIVING))result=false;
            if(sc.getSports().contains(Sports.HANDBALL))result=false;
            sc.removeMember(t2);
            if(sc.getSports().size()!=0)result=false;
            if(sc.getSports().contains(Sports.HOCKEY))result=false;
            if(sc.getSports().contains(Sports.PARKOUR))result=false;
            if(sc.getSports().contains(Sports.CLIMBING))result=false;
            if(sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.DIVING))result=false;
            if(sc.getSports().contains(Sports.HANDBALL))result=false;
            resultMap.put("Test15 SportsClub getSports()", result);

        }
        {
            //Test16 SportsClub calculateMembershipFee()
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.923223"));
            Map<Sports,Level> mappyMcMapFace=new HashMap<>();
            mappyMcMapFace.put(Sports.ARCHERY, Level.NORMAL);
            mappyMcMapFace.put(Sports.CLIMBING, Level.BEGINNER);
            mappyMcMapFace.put(Sports.DIVING, Level.PROFESSIONAL);
            mappyMcMapFace.put(Sports.GOLF, Level.ADVANCED);
            Trainer t1=new Trainer("Trainer1",mappyMcMapFace);
            mappyMcMapFace.put(Sports.BASKETBALL, Level.ADVANCED);
            Member m=new Member("Member",mappyMcMapFace);
            t1.learn(Sports.HOCKEY, Level.BEGINNER);
            mappyMcMapFace.clear();
            mappyMcMapFace.put(Sports.HOCKEY, Level.ADVANCED);
            Trainer t2=new Trainer("Trainer2",mappyMcMapFace);
            sc.addMember(t1);
            sc.addMember(t2);
            sc.addMember(m);
            if(!(sc.calculateMembershipFee(m).compareTo(new BigDecimal("261.8316603"))==0))result=false;
            if(!(sc.calculateMembershipFee(t1).compareTo(new BigDecimal("42.923223"))==0))result=false;
            if(!(sc.calculateMembershipFee(t2).compareTo(new BigDecimal("0"))==0))result=false;
            sc.removeMember(m);
            try {
                sc.calculateMembershipFee(m);
                result=false;
            }catch(Exception e) {
                if(!(e instanceof IllegalArgumentException))result=false;
            }
            resultMap.put("Test16 SportsClub calculateMembershipFee()", result);
        }
        {
            //Test17 SportsClub registerSports()
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.923223"));
            Map<Sports,Level> mappyMcMapFace=new HashMap<>();
            mappyMcMapFace.put(Sports.ARCHERY, Level.BEGINNER);
            mappyMcMapFace.put(Sports.BASKETBALL, Level.NORMAL);
            mappyMcMapFace.put(Sports.CLIMBING, Level.ADVANCED);
            mappyMcMapFace.put(Sports.DIVING, Level.PROFESSIONAL);
            Trainer t=new Trainer("Trainer",mappyMcMapFace);
            mappyMcMapFace.clear();
            mappyMcMapFace.put(Sports.BASKETBALL, Level.BEGINNER);
            mappyMcMapFace.put(Sports.CLIMBING, Level.ADVANCED);
            mappyMcMapFace.put(Sports.DIVING, Level.NORMAL);
            Member m=new Member("Member", mappyMcMapFace);
            sc.addMember(m);
            sc.addMember(t);
            if(m.getSports().size()!=3)result=false;
            if(!sc.registerSports(m, Sports.ARCHERY, Level.BEGINNER))result=false;
            if(m.getSports().size()!=4)result=false;
            if(m.getSports().get(Sports.ARCHERY)!=null) {
                if(!(m.getSports().get(Sports.ARCHERY).compareTo(Level.BEGINNER)==0))result=false;
            }else result=false;
            if(sc.registerSports(m, Sports.BASKETBALL, Level.ADVANCED))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!(m.getSports().get(Sports.BASKETBALL).compareTo(Level.BEGINNER)==0))result=false;
            }else result=false;
            if(!sc.registerSports(m, Sports.BASKETBALL, Level.NORMAL))result=false;
            if(m.getSports().get(Sports.BASKETBALL)!=null) {
                if(!(m.getSports().get(Sports.BASKETBALL).compareTo(Level.NORMAL)==0))result=false;
            }else result=false;
            if(sc.registerSports(m,Sports.CLIMBING, Level.BEGINNER))result=false;
            if(m.getSports().get(Sports.CLIMBING)!=null) {
                if(!(m.getSports().get(Sports.CLIMBING).compareTo(Level.ADVANCED)==0))result=false;
            }else result=false;
            if(sc.registerSports(m, Sports.DIVING, Level.PROFESSIONAL))result=false;
            if(m.getSports().get(Sports.DIVING)!=null) {
                if(!(m.getSports().get(Sports.DIVING).compareTo(Level.ADVANCED)==0))result=false;
            }else result=false;
            Trainer t2=new Trainer("Trainer2",mappyMcMapFace);
            sc.addMember(t2);
            if(t2.getSports().size()!=3)result=false;
            if(!sc.registerSports(t2, Sports.ARCHERY, Level.BEGINNER))result=false;
            if(t2.getSports().size()!=4)result=false;
            if(t2.getSports().get(Sports.ARCHERY)!=null) {
                if(!(t2.getSports().get(Sports.ARCHERY).compareTo(Level.BEGINNER)==0))result=false;
            }else result=false;
            if(sc.registerSports(t2, Sports.BASKETBALL, Level.ADVANCED))result=false;
            if(t2.getSports().get(Sports.BASKETBALL)!=null) {
                if(!(t2.getSports().get(Sports.BASKETBALL).compareTo(Level.BEGINNER)==0))result=false;
            }else result=false;
            if(!sc.registerSports(t2, Sports.BASKETBALL, Level.NORMAL))result=false;
            if(t2.getSports().get(Sports.BASKETBALL)!=null) {
                if(!(t2.getSports().get(Sports.BASKETBALL).compareTo(Level.NORMAL)==0))result=false;
            }else result=false;
            if(sc.registerSports(t2,Sports.CLIMBING, Level.BEGINNER))result=false;
            if(t2.getSports().get(Sports.CLIMBING)!=null) {
                if(!(m.getSports().get(Sports.CLIMBING).compareTo(Level.ADVANCED)==0))result=false;
            }else result=false;
            if(sc.registerSports(t2, Sports.DIVING, Level.PROFESSIONAL))result=false;
            if(t2.getSports().get(Sports.DIVING)!=null) {
                if(!(t2.getSports().get(Sports.DIVING).compareTo(Level.ADVANCED)==0))result=false;
            }else result=false;
            for(Member member:sc.getMembers()) {
                if(member.equals(m) || member.equals(t2)) {
                    if(member.getSports().size()!=4)result=false;
                    if(member.getSports().get(Sports.ARCHERY)!=null) {
                        if(!(member.getSports().get(Sports.ARCHERY).compareTo(Level.BEGINNER)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.BASKETBALL)!=null) {
                        if(!(member.getSports().get(Sports.BASKETBALL).compareTo(Level.NORMAL)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.CLIMBING)!=null) {
                        if(!(member.getSports().get(Sports.CLIMBING).compareTo(Level.ADVANCED)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.DIVING)!=null) {
                        if(!(member.getSports().get(Sports.DIVING).compareTo(Level.ADVANCED)==0))result=false;
                    }else result=false;
                    if(member instanceof Trainer) {
                        if(((Trainer)member).getAccreditations().size()!=3)result=false;
                        if(((Trainer)member).getAccreditations().get(Sports.ARCHERY)!=null)result=false;
                        if(((Trainer)member).getAccreditations().get(Sports.BASKETBALL)!=null) {
                            if(!(((Trainer)member).getAccreditations().get(Sports.BASKETBALL).compareTo(Level.BEGINNER)==0))result=false;
                        }else result=false;
                        if(((Trainer)member).getAccreditations().get(Sports.CLIMBING)!=null) {
                            if(!(((Trainer)member).getAccreditations().get(Sports.CLIMBING).compareTo(Level.ADVANCED)==0))result=false;
                        }else result=false;
                        if(((Trainer)member).getAccreditations().get(Sports.DIVING)!=null) {
                            if(!(((Trainer)member).getAccreditations().get(Sports.DIVING).compareTo(Level.NORMAL)==0))result=false;
                        }else result=false;
                    }
                }else {
                    if(member.getSports().size()!=4)result=false;
                    if(member.getSports().get(Sports.ARCHERY)!=null) {
                        if(!(member.getSports().get(Sports.ARCHERY).compareTo(Level.BEGINNER)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.BASKETBALL)!=null) {
                        if(!(member.getSports().get(Sports.BASKETBALL).compareTo(Level.NORMAL)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.CLIMBING)!=null) {
                        if(!(member.getSports().get(Sports.CLIMBING).compareTo(Level.ADVANCED)==0))result=false;
                    }else result=false;
                    if(member.getSports().get(Sports.DIVING)!=null) {
                        if(!(member.getSports().get(Sports.DIVING).compareTo(Level.PROFESSIONAL)==0))result=false;
                    }else result=false;
                    if(((Trainer)member).getAccreditations().size()!=4)result=false;
                }
            }
            resultMap.put("Test17 SportsClub registerSports()", result);
        }
        {
            //Test18 SportsClub addMember() removeMember()
            boolean result=true;
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.923223"));
            Map<Sports, Level> map=new HashMap<>();
            map.put(Sports.BASKETBALL, Level.ADVANCED);
            Member m=new Member("Member",map);
            map.clear();
            map.put(Sports.ARCHERY, Level.ADVANCED);
            Trainer t=new Trainer("Trainer",map);
            Trainer t2=new Trainer("Trainer2",map);
            if(!sc.addMember(m))result=false;
            if(!sc.addMember(t))result=false;
            if(sc.addMember(m))result=false;
            if(sc.addMember(t))result=false;
            if(sc.getMembers().size()!=2)result=false;
            if(sc.getSports().size()!=1)result=false;
            for(Member member:sc.getMembers()) {
                if(member instanceof Trainer) {
                    if(!member.getName().equals("Trainer"))result=false;
                }else {
                    if(!member.getName().equals("Member"))result=false;
                }
            }
            if(!sc.addMember(t2))result=false;
            if(sc.addMember(t2))result=false;
            if(sc.getMembers().size()!=3)result=false;
            if(!sc.toString().contains("ARCHERY"))result=false;//use toString() if your sc string doesnt contain the sports from offeredSPorts erase that line
            if(sc.getSports().size()!=1)result=false;
            if(!sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.BASKETBALL))result=false;
            if(!sc.removeMember(m))result=false;
            if(sc.removeMember(m))result=false;
            if(sc.getMembers().size()!=2)result=false;
            if(sc.getSports().size()!=1)result=false;
            if(!sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.BASKETBALL))result=false;
            if(!sc.removeMember(t))result=false;
            if(sc.removeMember(t))result=false;
            if(sc.getMembers().size()!=1)result=false;
            if(sc.getSports().size()!=1)result=false;
            if(!sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.BASKETBALL))result=false;
            if(!sc.toString().contains("ARCHERY"))result=false;//use toString() if your sc string doesnt contain the sports from offeredSPorts erase that line
            if(!sc.removeMember(t2))result=false;
            if(sc.removeMember(t2))result=false;
            if(sc.getMembers().size()!=0)result=false;
            if(sc.getSports().size()!=0)result=false;
            if(sc.getSports().contains(Sports.ARCHERY))result=false;
            if(sc.getSports().contains(Sports.BASKETBALL))result=false;
            if(sc.toString().contains("ARCHERY"))result=false;//use toString() if your sc string doesnt contain the sports from offeredSPorts erase that line
            resultMap.put("Test18 SportsClub addMember() removeMember()", result);
        }
        int cnt=0;
        for(boolean b:resultMap.values())if(b)++cnt;

        System.out.println("passed: "+cnt+"/"+resultMap.size());
        if(cnt!=resultMap.size()) {
            System.out.println("Failed Tests:");
            resultMap.forEach((k,v)-> {if(!v)System.out.println(k);});
        }
        {
            SportsClub sc=new SportsClub("SC",new BigDecimal("42.923223"));
            Map<Sports, Level> map=new HashMap<>();
            map.put(Sports.BASKETBALL, Level.ADVANCED);
            map.put(Sports.ARCHERY, Level.ADVANCED);
            Member m=new Member("Member",map);
            Trainer t=new Trainer("Trainer",map);

            System.out.println(sc.toString());
            System.out.println(m.toString());
            System.out.println(t.toString());
        }
    }
}