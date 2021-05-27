import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    private Long id;

    Map<Integer, String> name = new HashMap<>();
    Map<Integer,Integer> age = new HashMap<>();
    Map<Integer, String> gender = new HashMap<>();

    public void getUserByGender(String gender){
        ArrayList<Integer> users = new ArrayList<>();
        for (Integer id : this.gender.keySet()){
            if (this.gender.get(id).equals(gender)){
                users.add(id);
            }
        }
        ArrayList<String> usersNames = new ArrayList<>();
        for (Integer idUser : users){
            usersNames.add(name.get(idUser));
        }

        Object[] usersArray = usersNames.toArray();
        Object[] usersArrayId = users.toArray();
        System.out.println("Айди");
        for (Object id : usersArrayId){
            System.out.println(id);
        }
        System.out.println("Имя:");
        for (Object name : usersArray){
            System.out.println(name);
        }
    }
    public void getAllUsersAndAllGenders(){
        System.out.println(name.values());
        System.out.println(gender.values());
    }

    public ArrayList<Integer> getArrayOfUsersByGenders(String gender){
        ArrayList<Integer> users = new ArrayList<>();
        for (Integer i : this.gender.keySet()){
            if (this.gender.get(i).equals(gender)){
                users.add(i);
            }
        }
        return users;
    }
    public ArrayList<Integer> getAllUsersByAge(){
        ArrayList<Integer> users = new ArrayList<>();
        for (Integer i : age.keySet()){
            users.add(i);
        }
        return users;
    }

    public void genderToString(ArrayList<Integer> userID){ // присылается массив из айди у genders
        ArrayList<String> names = new ArrayList<>();
        for (Integer id : userID){ //идем по каждому айди
            names.add(name.get(id)); //присылаем в массив имя человека по ключу(айди)
        }
        Object[] users = names.toArray();
        for (Object i : users){
            System.out.println(i);
        }
    }
    public double getAverageAgeByUsers(ArrayList<Integer> usersID){
        double res = 0;
        double sum = 0;
        for (Integer id : usersID){
            sum+=age.get(id);
        }
        res = usersID.size();
        return sum/res;
    }

    public int NumberOfUsersByNames(){
        return name.size();
    }

    public int NumberOfUsersByArray(ArrayList<Integer> usersID){
        return usersID.size();
    }
    public ArrayList<Integer> getAllUsersByNames(){
        ArrayList<Integer> userIdList = new ArrayList<>();
        for (Integer id : name.keySet()){
            userIdList.add(id);
        }
        return userIdList;
    }
    public double getAverageByGender(String gender, ArrayList<Integer> usersID){
        double res = 0;
        double sum = 0;
        ArrayList<Integer> users = new ArrayList<>();
        for (Integer id : this.gender.keySet()){
            if (this.gender.get(id).equals(gender)){
                users.add(id);
            }
        }
        for (Integer id : users){
            for (Integer i : usersID){
                if (id.equals(i)){
                    sum+=age.get(id);
                }
            }
        }
        res = users.size();
        return sum/res;
    }

    public int getNumOfUsersByGender(String gender){
        ArrayList<Integer> usersIdList = new ArrayList<>();
        for (Integer id : this.gender.keySet()){
            if (this.gender.get(id).equals(gender)){
                usersIdList.add(id);
            }
        }
        return usersIdList.size();
    }

    public void putIntoNameMap(Integer key, String value){
        name.put(key,value);
    }
    public void putIntoGenderMap(Integer key, String value){
        gender.put(key,value);
        System.out.println("Ну молодец, ты добавил новую инфу!");
    }
    public void putIntoAgeMap(Integer key, Integer value){
        age.put(key,value);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Integer, String> getName() {
        return name;
    }

    public void setName(Map<Integer, String> name) {
        this.name = name;
    }

    public Map<Integer, Integer> getAge() {
        return age;
    }

    public void setAge(Map<Integer, Integer> age) {
        this.age = age;
    }

    public Map<Integer, String> getGender() {
        return gender;
    }

    public void setGender(Map<Integer, String> gender) {
        this.gender = gender;
    }
}
