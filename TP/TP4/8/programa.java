import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

class SWCharacter {
    private String name;
    private Integer height;
    private Double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;

    private Integer parseIndex;

    public SWCharacter() {
        this.name = null;
        this.height = null;
        this.mass = null;
        this.hairColor = null;
        this.skinColor = null;
        this.eyeColor = null;
        this.birthYear = null;
        this.gender = null;
        this.homeworld = null;
        this.parseIndex = null;
    }

    public SWCharacter(String path) throws IOException {
        this.parseIndex = 2;
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String json = f.readLine();

        this.name = this.jsonSubstring(json, "name");
        String height = this.jsonSubstring(json, "height");
        String mass = this.jsonSubstring(json, "mass");
        this.height = height.equals("unknown") ? 0 : Integer.parseInt(height);
        this.mass = mass.equals("unknown") ? 0 : Double.parseDouble(mass.replace(",", ""));
        this.hairColor = this.jsonSubstring(json, "hair_color");
        this.skinColor = this.jsonSubstring(json, "skin_color");
        this.eyeColor = this.jsonSubstring(json, "eye_color");
        this.birthYear = this.jsonSubstring(json, "birth_year");
        this.gender = this.jsonSubstring(json, "gender");
        this.homeworld = this.jsonSubstring(json, "homeworld");

        f.close();
    }

    private String jsonSubstring(String json, String key) {
        int start = this.parseIndex + key.length() + 4;
        this.parseIndex = start;
        while (json.charAt(this.parseIndex) != '\'')
            this.parseIndex++;
        this.parseIndex += 4;
        return json.substring(start, this.parseIndex - 4);
    }

    public SWCharacter clone() {
        SWCharacter clone = new SWCharacter();

        clone.name = this.name;
        clone.height = this.height;
        clone.mass = this.mass;
        clone.hairColor = this.hairColor;
        clone.skinColor = this.skinColor;
        clone.eyeColor = this.eyeColor;
        clone.birthYear = this.birthYear;
        clone.gender = this.gender;
        clone.homeworld = this.homeworld;

        return clone;
    }

    public String toString() {
        String str = " ## ";
        String stringMass = this.mass.toString();

        if (this.mass.intValue() == this.mass)
            stringMass = "" + this.mass.intValue();

        str += this.name + " ## ";
        str += this.height + " ## ";
        str += stringMass + " ## ";
        str += this.hairColor + " ## ";
        str += this.skinColor + " ## ";
        str += this.eyeColor + " ## ";
        str += this.birthYear + " ## ";
        str += this.gender + " ## ";
        str += this.homeworld + " ## ";

        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }
}

class Node {
    public char element;
    public final int len = 255;
    public Node[] next;
    public boolean sheet;

    public Node() {
        this(' ');
    }

    public Node(char element) {
        this.element = element;
        next = new Node[len];
        for (int i = 0; i < len; i++) {
            next[i] = null;
        }
        sheet = false;
    }

    public static int tree(char x) {
        return (int) x;
    }
}

class Trie {
    public Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String s) throws Exception {
        insert(s, root, 0);
    }

    private void insert(String s, Node node, int i) throws Exception {
        if (node.next[s.charAt(i)] == null) {
            node.next[s.charAt(i)] = new Node(s.charAt(i));

            if (i == s.length() - 1) {
                node.next[s.charAt(i)].sheet = true;
            } else {
                insert(s, node.next[s.charAt(i)], i + 1);
            }
        } else if (node.next[s.charAt(i)].sheet == false && i < s.length() - 1) {
            insert(s, node.next[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Error inserting!");
        }
    }

    public void merge(Trie tree) throws Exception {
        merge(tree, "", root);
    }

    private void merge(Trie tree, String s, Node node) throws Exception {
        if (node.sheet) {
            s = s.substring(1);
            tree.insert(s + node.element);
        } else {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    merge(tree, s + node.element, node.next[i]);
                }
            }
        }
    }

    public boolean search(String s) throws Exception {
        return search(s, root, 0);
    }

    public boolean search(String s, Node no, int i) throws Exception {
        boolean resp;
        if (no.next[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = (no.next[s.charAt(i)].sheet == true);
        } else if (i < s.length() - 1) {
            resp = search(s, no.next[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Error searching!");
        }
        return resp;
    }

}

public class programa {
    public static Scanner br = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String str = new String();
        Trie tree = new Trie();
        Trie tree2 = new Trie();
        try {
            while (!(str = br.nextLine()).equals("FIM")) {
                tree.insert(new SWCharacter(str).getName());
            }
            while (!(str = br.nextLine()).equals("FIM")) {
                tree2.insert(new SWCharacter(str).getName());
            }
        } catch (IOException e) {
            System.out.println("Error!" + e);
        }
        tree2.merge(tree);

        while (!(str = br.nextLine()).equals("FIM")) {
            System.out.print(str);
            if (tree.search(str)) {
                MyIO.print(" SIM\n");
            } else {
                MyIO.print(" NÃO\n");
            }
        }

    }
}
