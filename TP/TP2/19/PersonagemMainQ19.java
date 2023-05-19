import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

class Personagem{
    //atributes
    private String name;
    private int heigth;
    private double weigth;
    private String colorHair;
    private String colorSkin;
    private String colorEye;
    private String birthYear;
    private String gender;
    private String homeWorld;
    
    //constructors
    Personagem() {
        this.name = "";
        this.heigth = 0;
        this.weigth = 0;
        this.colorHair = "";
        this.colorSkin = "";
        this.colorEye = "";
        this.birthYear = "";
        this.gender = "";
        this.homeWorld = "";
    }

    Personagem(String name, int heigth, double weigth, String colorHair, String colorSkin, String colorEye, 
    String birthYear, String gender, String homeWorld){
        this.name = name;
        this.heigth = heigth;
        this.weigth = weigth;
        this.colorHair = colorHair;
        this.colorSkin = colorSkin;
        this.colorEye = colorEye;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
    }

    // sets
    public void setName(String name){   
        this.name = name;
    }
    public void setHeigth(int heigth){
        this.heigth = heigth;
    }
    public void setWeigth(double weigth){
        this.weigth = weigth;
    }
    public void setColorHair(String colorHair){
        this.colorHair = colorHair;
    }
    public void setColorSkin(String colorSkin){
        this.colorSkin = colorSkin;
    }
    public void setColorEye(String colorEye){
        this.colorEye = colorEye;
    }
    public void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setHomeWorld(String homeWorld){
        this.homeWorld = homeWorld;
    }

    //gets
    public String getName(){
        return name;
    }
    public int getHeigth(){
        return heigth;
    }
    public double getWeigth(){
        return weigth;
    }
    public String getColorHair(){
        return colorHair;
    }
    public String getColorSkin(){
        return colorSkin;
    }
    public String getColorEye(){
        return colorEye;
    }
    public String getBirthYear(){
        return birthYear;
    }
    public String getGender(){
        return gender;
    }
    public String getHomeWorld(){
        return homeWorld;
    }

    //clone
    public Personagem clonePerson(){
        Personagem tmp = new Personagem();
        tmp.name = this.name;
        tmp.heigth = this.heigth;
        tmp.weigth = this.weigth;
        tmp.colorHair = this.colorHair;
        tmp.colorSkin = this.colorSkin;
        tmp.colorEye = this.colorEye;
        tmp.birthYear = this.birthYear;
        tmp.gender = this.gender;
        tmp.homeWorld = this.homeWorld;
        return tmp;
    }
    
    //imprimir
    public void imprimir(){

        System.out.print("## " + name + " ## " + heigth + " ## ");
        printDouble(weigth);
        System.out.println(" ## " + colorHair + " ## " + colorSkin + " ## " + colorEye + " ## " + birthYear 
        + " ## " + gender + " ## " + homeWorld + " ## ");
    }
    
    //ler
    public void read(String Person){
        
        for(int i = 0; i < (Person.length()-1); i++){
            //name
            if(Person.charAt(i) == 'n' && Person.charAt(i+1) == 'a' && Person.charAt(i+2) == 'm' 
            && Person.charAt(i+3) == 'e'){
                i = i+8;
                String tmp = "";
                for(int j = i; j<Person.length()-1;j++){
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length()+1;
                    }
                }
                this.setName(tmp);
            }
            
            //heigth
            if(Person.charAt(i) == 'h' && Person.charAt(i+1) == 'e' && Person.charAt(i+2) == 'i' && 
            Person.charAt(i+3) == 'g' && Person.charAt(i+4) == 'h' && Person.charAt(i+5) == 't'){
                i = i+10;
                String tmp = "";
                for(int j = i; j < Person.length()-1; j++){
                    tmp+=Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                if(isUnknown(tmp)){
                    this.heigth = 0;
                }else{
                    this.setHeigth(Integer.parseInt(tmp));
                }
            }
            
            //weigth || mass
            if(Person.charAt(i) == 'm' && Person.charAt(i+1) == 'a' && Person.charAt(i+2) == 's' && 
            Person.charAt(i+3) == 's'){
                i = i+8;
                String tmp = "";
                for(int j = i; j < Person.length()-1;j++){
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                tmp = isComma(tmp);
                if(isUnknown(tmp)){
                    this.weigth = 0;
                }else{
                    this.setWeigth(Double.parseDouble(tmp));
                }
            }
            
            //haircolor
            if(Person.charAt(i) == 'h' && Person.charAt(i+1) == 'a' && Person.charAt(i+2) == 'i' &&
            Person.charAt(i+3) == 'r'){
                i +=14;
                String tmp = "";
                for(int j = i; j < Person.length()-1; j++){
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char) 39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                this.setColorHair(tmp);
            }
            
            //skincolor
            if(Person.charAt(i) == 's' && Person.charAt(i+1) == 'k' && Person.charAt(i+2) == 'i' && 
            Person.charAt(i+3) == 'n'){
                i += 14;
                String tmp = "";
                for(int j = i; j < Person.length()-1; j++){
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                this.setColorSkin(tmp);
            }
            
            //eyecolor
            if(Person.charAt(i) == 'e' && Person.charAt(i+1) == 'y' && Person.charAt(i+2) == 'e'){
                i += 13;
                String tmp = "";
                for(int j = i; j < Person.length()-1;j++){
                    
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                this.setColorEye(tmp);
            }
            
            //birthyear
            if(Person.charAt(i) == 'b' && Person.charAt(i+1) == 'i' && Person.charAt(i+2) == 'r' && 
            Person.charAt(i+3) == 't' && Person.charAt(i+4) == 'h'){
                i += 14;
                String tmp = "";
                for(int j = i; j < Person.length()-1;j++){
                    tmp += Person.charAt(j);
                    
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                this.setBirthYear(tmp);
            }
            //gender
            if(Person.charAt(i) == 'g' && Person.charAt(i+1) == 'e' && Person.charAt(i+2) == 'n' &&
            Person.charAt(i+3) == 'd' && Person.charAt(i+4) == 'e' && Person.charAt(i+5) == 'r'){
                i+=10;
                String tmp = "";
                for(int j = i; j < Person.length()-1; j++){
                    tmp += Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j +2;
                        j = Person.length();
                    }
                }
                this.setGender(tmp);
            }
            //homeworld
            if(Person.charAt(i) == 'h' && Person.charAt(i+1) == 'o' && Person.charAt(i+2) == 'm' && 
            Person.charAt(i+3) == 'e' && Person.charAt(i+4) == 'w' && Person.charAt(i+5) == 'o' && 
            Person.charAt(i+6) == 'r' && Person.charAt(i+7) == 'l' && Person.charAt(i+8) == 'd'){
                i += 13;
                String tmp = "";
                for(int j = i; j < Person.length(); j++){
                    tmp+=Person.charAt(j);
                    if(Person.charAt(j+1) == (char)39){
                        i = j+2;
                        j = Person.length();
                    }
                }
                i = Person.length();
                this.setHomeWorld(tmp);
            }        
        }
    }
    
    public String removeSpace(String line){
        String str = new String();
        for(int i = 0; i < (line.length()-1) ;i++){
            if(line.charAt(i) != ' '){
                str += line.charAt(i);
            }
        }
        return str;
    }
    // tira casa decimal
    public void printDouble(double a){
        if((a * 10)% 10 == 0){
            System.out.print((int)a);
        } else {
            System.out.print(a);
        }
    }
    // se o resultado é unknown, deve ser aplicado apenas para height & weigth
    public boolean isUnknown(String word){
        if(word.equals("unknown")){
            return true;
        }
        return false;
    }
    // tirar virgula
    public String isComma(String word){
        String tmp = new String();
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ','){
                //    tmp += '.';
            } else {
                tmp += word.charAt(i);
            }
        }
        return tmp;
    }
}
// Lista
class Lista extends Personagem{
    public static Personagem[] person = new Personagem[100];
    public static int index;
    public static int movimentacoes = 0; 
    public static int comparacoes = 0;
    
    //inserirInicio
    public static void inserirInicio(Personagem personagem) throws Exception{
        if(index >= person.length)
        throw new Exception("Erro: lista cheio");
        for(int i = index; i > 0; i--){
            person[i] = person[i-1];
        }
        person[0] = personagem.clonePerson();
        index++;
    }
    
    //inserir
    public static void inserir(Personagem personagem, int pos)throws Exception{
        if(index >= person.length)
        throw new Exception("Erro: lista cheia");
        for(int i = index; i > pos; i--){
            person[i] = person[i-1];
        }
        person[pos] = personagem.clonePerson();
        index++;
    }
    
    //inserirFim
    public static void inserirFim(Personagem personagem) throws Exception{
        if(index >= person.length)
            throw new Exception("Erro: lista cheia");
            person[index] = personagem.clonePerson();
            index++;
        }
        
        //removerInicio
        public static Personagem removerInicio() throws Exception{
            if(index == 0)
            throw new Exception("Erro: lista vazia");
            Personagem tmp = person[0];
        index--;
        for(int i = 0; i < index;i++){
            person[i] = person[i+1];
        }
        return tmp;
    }

    //remover
    public static Personagem remover(int pos)throws Exception{
        if(index == 0 || pos>=index || pos < 0)
            throw new Exception("Erro!");
        Personagem tmp = person[pos];
        for(int i = pos; i < index; i++){
            person[i] = person[i+1];
        }
        index--;
        return tmp;
    }

    //removerFim
    public static Personagem removerFim()throws Exception{
        if(index == 0)
            throw new Exception("Erro: lista vazia");
        Personagem tmp = person[--index];
        return tmp;
    }
    
    //ler lista -> mostrar
    public static void mostrar(){
        for(int i = 0; i < index; i++){
            //System.out.print("["+i+"]  ");
            person[i].imprimir();
        }
    }
    
    //parsetoInt
    public static int parsetoInt(String line){
        String num = new String();
        for(int i = 0; i <line.length();i++){
            if(line.charAt(i) != ' '){
                num+=line.charAt(i);
            } else {
                i = line.length();
            }
        }
        return Integer.parseInt(num);
    }
    
    //readArq
    public static String readArq(String path){
        String line = new String();
        try{
            Scanner sc = new Scanner(new File(path),"ISO-8859-1");
           line = sc.nextLine();
           sc.close();
       }catch (FileNotFoundException e){
           System.out.println("Error: File not found");
       }
       return line;
    }

    //create and write arq
    public static void writeArq(){
        File arq = new File("matrícula sequencial.txt");
        try{
            FileWriter filewriter = new FileWriter(arq);
            filewriter.write("Matricula: 797100\t"+comparacoes+"\t");
            filewriter.close();
        }catch(IOException e){
            System.out.println("Error: "+e);
        }
    }

    //swap
    public static void swap(int pos, int pos2){
        Personagem tmp = person[pos].clonePerson();
        person[pos] = person[pos2].clonePerson();
        person[pos2] = tmp.clonePerson();
        movimentacoes+=3;
    }

    //printtmp
    public static void printtmp(){
        for(int i = 0; i < index; i++){
            System.out.println(person[i].getHeigth());
        }
    }
}

public class PersonagemMainQ19 extends Lista{
    
    public static void print10(){
        for(int i = 0; i < 10; i++)
            person[i].imprimir();

    }
    
    public static void SelectionSortParcial(){
        for(int i = 0; i < 10; i++){
            int menor = i;
            for(int j = (i+1); j < index; j++){
                if(person[menor].getName().compareTo(person[j].getName()) > 0)
                    menor = j;
            }
            swap(menor,i);
        }
    }
    
    public static void main(String[] args) throws Exception{    
        index = 0;
        Scanner inputReader = new Scanner(System.in);
        String line = inputReader.nextLine();
            
        while(!line.equals("FIM")){
            line = readArq(line);
            person[index] = new Personagem();
            person[index].read(line);
            index++;
            line = inputReader.nextLine();
        }
        SelectionSortParcial();
        print10();
        inputReader.close();
    }

}